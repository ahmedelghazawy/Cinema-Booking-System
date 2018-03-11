from django import forms
from django.contrib.auth import authenticate, login, get_user_model, logout

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
    #     email = self.cleaned_data.get('email')
    #     email2 = self.cleaned_data.get('email2')
    #     if email != email2:
    #         raise forms.ValidationError("emails do not match")
    #     tempEmail = User.objects.filter(email=email)
    #     if tempEmail.exists():
    #         raise forms.ValidationError("email already exists")
    #     return super(UserRegisterForm, self).clean(*args, **kwargs)

    def clean_email2(self):
        email = self.cleaned_data.get('email')
        email2 = self.cleaned_data.get('email2')
        if email != email2:
            raise forms.ValidationError("emails do not match")
        tempEmail = User.objects.filter(email=email)
        if tempEmail.exists():
            raise forms.ValidationError("email already exists")
        return email
