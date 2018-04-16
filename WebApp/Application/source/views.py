from django.shortcuts import render, get_object_or_404, redirect
from rest_framework.views import APIView
from rest_framework.response import Response
from rest_framework import status
from django.http import HttpResponse
from django.db import models
from source.models import *
from source.forms import *
from source.serializers import *
import datetime
from django.contrib.auth.forms import UserCreationForm
from django.contrib.auth import authenticate, login, get_user_model, logout
from django.contrib.auth.decorators import login_required
from django.contrib.auth import get_user_model

#import pyfpdf
# Create your views here.
def index(request):
	latestMovies = Movie.objects.order_by('-releaseDate')[:4]
	return render(request,'index.html',{'nbar':'home','latestMovies':latestMovies})

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


def checkoutPage(request):
	movies = Movie.objects.all()
	return render(request,'checkoutPage.html' )

def confirmation(request):
	movies = Movie.objects.all()
	return render(request,'confirmation.html' )

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
	currentDateTime = datetime.datetime.today()
	currentTime = currentDateTime.time()
	currentDate = currentDateTime.date()
	# Stores the types of stars to print
	stars = []
	for star in range(0,10,2):
		type = movie.rating - star
		if( type >= 1.5 ):
			stars.append(2)
		elif( type <1.5 and type>=0.5 ):
			stars.append(1)
		else:
			stars.append(0)
	# Get all avaiable dates with times for the current movie and sort it
	timings = Screening.objects.order_by('data').order_by('time').all().filter(movie_id=MovieID)
	# Gets a 2d array with days: 1,2,3... and their avaiable timings
	dates = []
	for day in range(0,7):
		name = ""
		# Get the date
		dayFromToday = currentDate + datetime.timedelta(days=day)
		# Get the string for date
		if (day==0):
			name = "Today"
		else:
			name = dayFromToday.strftime("%A")
		# Add the date string ant the timings for the date to array
		dates.append([name, timings.filter(date=dayFromToday)])
	# Get 4 latest movies
	latestMovies = Movie.objects.order_by('-releaseDate')[:4]
	return render(request,'movieBlurb.html',{'movie':movie, 'currentTime':currentTime, 'dates':dates, 'latestMovies':latestMovies, 'stars':stars} )


def bookingPage(request, ScreeningID):
	screening = Screening.objects.filter(id = ScreeningID).first()
	temp = screening.screen_id.id
	screen = Screen.objects.filter(id = temp).first()
	totalSeats = screen.standardSeats
	#emptySeats =
	seats = Seat.objects.filter(screening_id = ScreeningID).all().count()
	return render(request,'booking.html',{'nbar':'whatson','seats':seats, 'totalSeats':totalSeats} )

def bookingChoose(request, screeningId):
	# Passing first element of the query as query is a list with 1 object
	screening = Screening.objects.filter(id=screeningId)[0]
	movie = screening.movie_id
	screen = screening.screen_id
	return render(request,'bookingChoose.html',{'nbar':'whatson','movie':movie, 'screen':screen, 'screening':screening} )




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
		date = datetime.datetime.strptime(date, "%Y-%m-%d").date()
		timing = Screening.objects.filter(movie_id = movie).filter(date = date).all()
		serializer = ScreeningSerializer(timing, many=True)
		return Response(serializer.data)


class screenapi(APIView):
	def get(self, request, screeningId):
		screening = Screening.objects.filter(id = screeningId).first()
		screen = screening.screen_id
		#screen = Screen.objects.filter(id = screenId).first()
		serializer = ScreenSerializer(screen, many=False)
		return Response(serializer.data)

class seatingapi(APIView):
	def get(self, request, screeningId):
		seats = Seat.objects.filter(screening_id = screeningId).all()
		serializer = SeatSerializer(seats , many = True)
		return Response(serializer.data)
