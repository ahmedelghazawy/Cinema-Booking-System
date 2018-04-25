from django import forms
from django.contrib.auth import authenticate, login, get_user_model, logout
from django.core.validators import MaxValueValidator, MinValueValidator, RegexValidator, MaxLengthValidator
import datetime
class BookingForm(forms.Form):
	normal = forms.DecimalField(validators=[MaxValueValidator(99,message="Too many normal seats chosen"),MinValueValidator(0,message="You can't have negative seats...")])
	normal.widget.attrs.update({'class': 'form-control','max':99,'min':0,'value':0})

	student = forms.DecimalField(validators=[MaxValueValidator(99,message="Too many student seats chosen"),MinValueValidator(0,message="You can't have negative seats...")])
	student.widget.attrs.update({'class': 'form-control','max':99,'min':0,'value':0})

	senior = forms.DecimalField(validators=[MaxValueValidator(99,message="Too many senior seats chosen"),MinValueValidator(0,message="You can't have negative seats...")])
	senior.widget.attrs.update({'class': 'form-control','max':99,'min':0,'value':0})

	vip = forms.DecimalField(validators=[MaxValueValidator(99,message="Too many vip seats chosen"),MinValueValidator(0,message="You can't have negative seats...")])
	vip.widget.attrs.update({'class': 'form-control noedit','max':99,'min':0,'value':0,'readonly':True})

	child = forms.DecimalField(validators=[MaxValueValidator(99,message="Too many child seats chosen"),MinValueValidator(0,message="You can't have negative seats...")])
	child.widget.attrs.update({'class': 'form-control','max':99,'min':0,'value':0})

	name = forms.CharField(max_length = 100,label='Name')
	number = forms.CharField(label='Card number',validators=[RegexValidator(
            regex='\d{16}',
            message='The card number must be exactly 16 numbers long',
            code='invalid_number'
        ),])
	cvc = forms.DecimalField(label='CVC number',validators=[MaxValueValidator(999,message="CVC can only be 3 digits long"),MinValueValidator(100,message="CVC has to be 3 digits long")])
	year = forms.DecimalField(label='Expiry year',validators=[MinValueValidator(2018,message="Your card is expired"),MaxValueValidator(2100,message="Your card cannot be valid for so long")])
	month = forms.DecimalField(label='Expiry month',validators=[MinValueValidator(1,message="The month has to be between 1 and 12 months"),MaxValueValidator(12,message="The month has to be between 1 and 12 months")])
	seats = forms.CharField(required=False)
	name.widget.attrs.update({'class':'form-control'})
	number.widget.attrs.update({'class':'form-control'})
	cvc.widget.attrs.update({'class':'form-control'})
	year.widget.attrs.update({'class':'form-control'})
	month.widget.attrs.update({'class':'form-control'})
	seats.widget.attrs.update({'class':'form-control noedit','readonly':True})

	def clean_seats(self):
		seats = self.cleaned_data.get("seats")
		if seats == '':
			seats = 0
		else:
			seats = len(seats.split(','))
		normal = int(self.cleaned_data['normal'])
		student = int(self.cleaned_data['student'])
		senior = int(self.cleaned_data['senior'])
		child = int(self.cleaned_data['child'])
		totalSeats = normal+student+senior+child
		if (totalSeats <= 0):
			raise forms.ValidationError("Please choose the amout of seats wanted.")
		if (totalSeats > seats):
			raise forms.ValidationError("Please choose all of the requested seats. You chose {} out of {} seats.".format(seats,totalSeats))
		return self.cleaned_data.get("seats")

User = get_user_model()
class UserLoginForm(forms.Form):
    username = forms.CharField(label = "username")
    password = forms.CharField(label = "password", widget=forms.PasswordInput)

    def clean(self, *args, **kwargs):
        username = self.cleaned_data.get('username')
        password = self.cleaned_data.get('password')
        if username and password:
            user = authenticate(username = username, password = password)
            if not user:
                raise forms.ValidationError("User does not exist")
            if not user.check_password(password):
                raise forms.ValidationError("incorrect password")
        return super(UserLoginForm, self).clean(*args, **kwargs)

class UserRegisterForm(forms.ModelForm):
	username = forms.CharField(label = "username")
	email = forms.EmailField(label = "email address")
	dob = forms.CharField(label = "dob")
	password = forms.CharField(widget=forms.PasswordInput)
	confirmpassword = forms.CharField(widget=forms.PasswordInput)

	class Meta:
		model = User
		fields = ['username', 'email', 'password', 'confirmpassword','dob']

	def clean_email2(self):
		email = self.cleaned_data.get('email')
			#     email2 = self.cleaned_data.get('email2')
			#     if email != email2:
			#         raise forms.ValidationError("emails do not match")
		tempEmail = User.objects.filter(email=email)
		if tempEmail.exists():
			raise forms.ValidationError("email already exists")
			return email
