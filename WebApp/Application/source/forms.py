from django import forms
from django.contrib.auth import authenticate, login, get_user_model, logout
from django.core.validators import MaxValueValidator, MinValueValidator, RegexValidator, MaxLengthValidator

class BookingForm(forms.Form):
	normal = forms.DecimalField(validators=[MaxValueValidator(99),MinValueValidator(0)])
	normal.widget.attrs.update({'class': 'form-control','max':99,'min':0,'value':0})

	student = forms.DecimalField(validators=[MaxValueValidator(99),MinValueValidator(0)])
	student.widget.attrs.update({'class': 'form-control','max':99,'min':0,'value':0})

	senior = forms.DecimalField(validators=[MaxValueValidator(99),MinValueValidator(0)])
	senior.widget.attrs.update({'class': 'form-control','max':99,'min':0,'value':0})

	vip = forms.DecimalField(validators=[MaxValueValidator(99),MinValueValidator(0)])
	vip.widget.attrs.update({'class': 'form-control noedit','value':0,'readonly':True})

	child = forms.DecimalField(validators=[MaxValueValidator(99),MinValueValidator(0)])
	child.widget.attrs.update({'class': 'form-control','max':99,'min':0,'value':0})

	name = forms.CharField(max_length = 100,label='Name')
	number = forms.CharField(label='Card number',validators=[RegexValidator(
            regex='\d{16}',
            message='The card number must be exactly 16 numbers long',
            code='invalid_number'
        ),])
	cvc = forms.DecimalField(label='CVC number',validators=[MaxValueValidator(999),MinValueValidator(0)])
	year = forms.DecimalField(label='Expiry year',validators=[MinValueValidator(2018),MaxValueValidator(2050)])
	month = forms.DecimalField(label='Expiry month',validators=[MinValueValidator(1),MaxValueValidator(12)])
	seats = forms.CharField(required=False)
	name.widget.attrs.update({'class':'form-control'})
	number.widget.attrs.update({'class':'form-control'})
	cvc.widget.attrs.update({'class':'form-control'})
	year.widget.attrs.update({'class':'form-control'})
	month.widget.attrs.update({'class':'form-control'})
	seats.widget.attrs.update({'class':'form-control noedit','readonly':True})

	def clean_seats(self):
		seats = self.cleaned_data.get("seats")
		print(seats)
		if seats == '':
			seats = 0
		else:
			seats = len(seats.split(','))
		print(seats)
		normal = int(self.cleaned_data['normal'])
		student = int(self.cleaned_data['student'])
		senior = int(self.cleaned_data['senior'])
		child = int(self.cleaned_data['child'])
		totalSeats = normal+student+senior+child
		if (totalSeats > seats):
			raise forms.ValidationError("Please choose all of the requested seats. You chose {} out of {} seats.".format(seats,totalSeats))


User = get_user_model()
class UserLoginForm(forms.Form):
	username = forms.CharField()
	password = forms.CharField(widget=forms.PasswordInput)

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
	email = forms.EmailField(label = "email address")
	email2 = forms.EmailField(label = "confirm email")
	password = forms.CharField(widget=forms.PasswordInput)
	class Meta:
		model = User
		fields = ['username', 'email','email2', 'password']

	# def clean(self, *args, **kwargs):
	#	 email = self.cleaned_data.get('email')
	#	 email2 = self.cleaned_data.get('email2')
	#	 if email != email2:
	#		 raise forms.ValidationError("emails do not match")
	#	 tempEmail = User.objects.filter(email=email)
	#	 if tempEmail.exists():
	#		 raise forms.ValidationError("email already exists")
	#	 return super(UserRegisterForm, self).clean(*args, **kwargs)

	def clean_email2(self):
		email = self.cleaned_data.get('email')
		email2 = self.cleaned_data.get('email2')
		if email != email2:
			raise forms.ValidationError("emails do not match")
		tempEmail = User.objects.filter(email=email)
		if tempEmail.exists():
			raise forms.ValidationError("email already exists")
		return email
