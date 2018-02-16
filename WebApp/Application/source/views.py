from django.shortcuts import render
from django.http import HttpResponse
from django.db import models
from source.models import *

# Create your views here.
def index(request):

	return render(request,'index.html',{'nbar':'home'})

def whatson(request):
	movies = Movie.objects.all()
	return render(request,'whatson.html',{'nbar':'whatson','movies':movies} )

def test1(request):

	return HttpResponse("<h1>test 1</h1>")


def test2(request):

	return HttpResponse("<h1>test 2</h1>")
