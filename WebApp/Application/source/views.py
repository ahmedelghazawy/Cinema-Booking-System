from django.shortcuts import render
from django.http import HttpResponse
from django.db import models
from source.models import *

# Create your views here.
def index(request):
	latest_movies = Movie.objects.order_by('-releaseDate')[:4]
	return render(request,'index.html',{'nbar':'home','latest_movies':latest_movies})

def whatson(request):
	movies = Movie.objects.all()
	return render(request,'whatson.html',{'nbar':'whatson','movies':movies} )

def moviePage(request, MovieID):
	movie = Movie.objects.get(id=MovieID)
	screenings = Screening.objects.all()
	timings = Timing.objects.all()
	return render(request,'movieTile.html',{'movie':movie, 'screenings':screenings, 'timings':timings} )


def test2(request):

	return HttpResponse("<h1>test 2</h1>")
