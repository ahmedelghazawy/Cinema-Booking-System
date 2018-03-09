from django.shortcuts import render, get_object_or_404
from rest_framework.views import APIView
from rest_framework.response import Response
from rest_framework import status
from django.http import HttpResponse
from django.db import models
from source.models import *
from source.serializers import *
from datetime import datetime, time

# Create your views here.
def index(request):
	latest_movies = Movie.objects.order_by('-releaseDate')[:4]
	return render(request,'index.html',{'nbar':'home','latest_movies':latest_movies})

def whatson(request):
	movies = Movie.objects.all()
	return render(request,'whatson.html',{'nbar':'whatson','movies':movies} )

def moviePage(request, MovieID):
	movie = Movie.objects.filter(id=MovieID).first()
	currentDateTime = datetime.now()
	currentTime = currentDateTime.time
	timings = Screening.objects.order_by('time').all()
	latest_movies = Movie.objects.order_by('-releaseDate')[:4]
	return render(request,'movieTile.html',{'movie':movie, 'timings':timings, 'currentTime':currentTime, 'latest_movies':latest_movies} )

def bookingPage(request):
	seats = Seat.objects.filter(screening_id = 1).all()
	return render(request,'booking.html',{'nbar':'whatson','seats':seats} )

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
class seatingapi(APIView):
	def get(self, request, screeningId):
		seats = Seat.objects.filter(screening_id = screeningId).all()
		serializer = SeatSerializer(seats , many = True)
		return Response(serializer.data)
