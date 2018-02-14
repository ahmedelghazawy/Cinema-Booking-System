from django.shortcuts import render
from django.http import HttpResponse

# Create your views here.
def index(request):

    return render(request,'index.html')


def test1(request):

    return HttpResponse("<h1>test 1</h1>")


def test2(request):

    return HttpResponse("<h1>test 2</h1>")
