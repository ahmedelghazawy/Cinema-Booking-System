from django.shortcuts import render, get_object_or_404, redirect
from rest_framework.views import APIView
from rest_framework.response import Response
from rest_framework import status
from django.http import HttpResponse
from django.db import models
from source.models import *
from source.forms import *
from source.serializers import *
from datetime import datetime, time
from django.contrib.auth.forms import UserCreationForm
from django.contrib.auth import authenticate, login, get_user_model, logout
from django.contrib.auth.decorators import login_required
from django.contrib.auth import get_user_model
# Create your views here.
def index(request):
	latest_movies = Movie.objects.order_by('-releaseDate')[:4]
	return render(request,'index.html',{'nbar':'home','latest_movies':latest_movies})

def whatson(request):
	movies = Movie.objects.all()
	return render(request,'whatson.html',{'nbar':'whatson','movies':movies} )

def loginPage(request):
	title="login"
	form = UserLoginForm(request.POST or None)
	if form.is_valid():
		username = form.cleaned_data.get('username')
		password = form.cleaned_data.get('password')
		user = authenticate(username = username, password = password)
		login(request, user)
		return redirect("/")

	return render(request,'login.html',{'title':title,'form':form} )

def registerPage(request):
	title ="register"
	form = UserRegisterForm(request.POST or None)
	if form.is_valid():
		user = form.save(commit = False)
		password = form.cleaned_data.get('password')
		user.set_password(password)
		user.save()
		new_user = authenticate(username = user.username, password = password)
		login(request, new_user)
		return redirect("/")


	return render(request,'login.html',{'title':title,'form':form} )
def logoutPage(request):
	logout(request)
	return redirect("/")

def profilePage(request):
	if request.user.is_authenticated:
		tickets = Ticket.objects.filter(id = request.user.id).all()
	return render(request,'profile.html')

def moviePage(request, MovieID):
	movie = Movie.objects.filter(id=MovieID).first()
	currentDateTime = datetime.now()
	currentTime = currentDateTime.time
	timings = Screening.objects.order_by('time').all()
	latest_movies = Movie.objects.order_by('-releaseDate')[:4]
	return render(request,'movieTile.html',{'movie':movie, 'timings':timings, 'currentTime':currentTime, 'latest_movies':latest_movies} )

def bookingPage(request, ScreeningID):
	screening = Screening.objects.filter(id = ScreeningID).first()
	temp = screening.screen_id.id
	screen = Screen.objects.filter(id = temp).first()
	totalSeats = screen.standardSeats
	#emptySeats =
	seats = Seat.objects.filter(screening_id = ScreeningID).all().count()
	return render(request,'booking.html',{'nbar':'whatson','seats':seats, 'totalSeats':totalSeats} )

class whatsonapi(APIView):
	def get(self, request):
		movies = Movie.objects.all()
		serializer = MovieSerializer(movies, many=True)
		return Response(serializer.data)

class movieTimingsapi(APIView):
	def get(self, request, MovieID, date):
		movie = Movie.objects.filter(id = MovieID).first()
		movie = movie.id
		#dateString = year + "-" + month + "-" + day
		date = datetime.strptime(date, "%Y-%m-%d").date()
		timing = Screening.objects.filter(movie_id = movie).filter(date = date).all()
		serializer = ScreeningSerializer(timing, many=True)
		return Response(serializer.data)
