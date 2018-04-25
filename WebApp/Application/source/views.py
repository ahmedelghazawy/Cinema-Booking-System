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
from django.views.decorators.csrf import csrf_exempt
from django.core.mail import send_mail
from django.conf import settings
from django.http import Http404

#libaries for email
from django.core import mail
from django.template.loader import render_to_string
from django.utils.html import strip_tags
from django.core.mail import EmailMessage
import pyqrcode
import cairosvg
import os

def confirmation(request):
	return render(request,'confirmation.html')
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
	next = request.GET.get('next')
	if form.is_valid():
		username = form.cleaned_data.get('username')
		password = form.cleaned_data.get('password')
		user = authenticate(username = username, password = password)
		login(request, user)
		if next:
			return redirect(next)

		return redirect("/")
	return render(request,'login.html',{'title':title,'form':form} )


def checkoutPage(request):
	movies = Movie.objects.all()
	return render(request,'checkoutPage.html' )

def registerPage(request):
	title ="register"
	form = UserRegisterForm(request.POST or None)
	next = request.GET.get('next')
	if form.is_valid():
		user = form.save(commit = False)
		password = form.cleaned_data.get('password')
		user.set_password(password)
		user.save()
		new_user = authenticate(username = user.username, password = password)
		login(request, new_user)
		if next:
			return redirect(next)
		return redirect("/")
	return render(request,'register.html',{'title':title,'form':form} )

def logoutPage(request):
	logout(request)
	return redirect("/")

def profilePage(request):
	if request.user.is_authenticated:
		tickets = Ticket.objects.filter(user_id = request.user.id).all()
		allTickets = {}
		for ticket in tickets:
			if (ticket.screening_id in allTickets.keys()):
				allTickets[ticket.screening_id].append(ticket)
			else:
				allTickets[ticket.screening_id] = [ticket]
		return render(request,'profilePage.html',{'movieTickets':allTickets})
	else:
		return redirect("/")

def moviePage(request, MovieID):
	movie = Movie.objects.filter(id=MovieID).first()
	if (movie == None):
		raise Http404
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


def bookingPage(request):
	seats = Seat.objects.filter(screening_id = 1).all()
	return render(request,'booking.html',{'nbar':'whatson','seats':seats} )

@login_required(login_url='/login')
def bookingChoose(request, screeningId):
	# Passing first element of the query as query is a list with 1 object
	form = BookingForm(request.POST or None)
	if form.is_valid():
		# Get all the data from form
		normal = int(form.cleaned_data['normal'])
		student = int(form.cleaned_data['student'])
		senior = int(form.cleaned_data['senior'])
		vip = int(form.cleaned_data['vip'])
		child = int(form.cleaned_data['child'])
		tickets = {'normal':normal,'student':student,'senior':senior,'child':child}
		print(tickets)
		name = form.cleaned_data['name']
		number = form.cleaned_data['number']
		cvc = form.cleaned_data['cvc']
		year = form.cleaned_data['year']
		month = form.cleaned_data['month']
		seats = form.cleaned_data['seats'].split(",")
		# Total amount of tickets purchased
		total_seats = normal+student+senior+child
		# Details of booking
		screening = Screening.objects.filter(id=screeningId)[0]
		movie = screening.movie_id

		#email data
		subject = 'Your Toucan cinema booking'
		html_message = render_to_string('email.html', {'context': 'values', 'movie': movie})
		plain_message = strip_tags(html_message)
		from_email = settings.EMAIL_HOST_USER
		to_email = ""
		#email attributes
		email = EmailMessage(subject,plain_message,	from_email,	to_email,[],
			headers={'Message-ID': 'Toucan Cinema'},
		)

		for x in range(total_seats):
			# Set VIP flag
			isVip = False
			if (x - vip > 0):
				isVip = True
			# Set ticket type
			ticket_type = ""
			for key, value in tickets.items():
				print("key {} val {}".format(key,value))
				if (value > 0):
					ticket_type = key
					tickets[key] -= 1
					break
			print(ticket_type)
			# Save the seat and ticket to database
			seat = Seat(screening_id = screening,vipSeat = isVip,row=seats[x][0:1],column=seats[x][1:2])
			seat.save()
			ticket = Ticket(movie_id = movie,screening_id = screening, seat_id=seat,ticket_type=ticket_type )
			ticket.save()
			# Generate QR code
			codeQR = pyqrcode.create(str(ticket.id), error='L', version=6, mode='binary')
			codeQR.svg(str(ticket.id)+'.svg', scale=8)

			# Generate pdf QR code for email
			cairosvg.svg2pdf(url=str(ticket.id)+'.svg', write_to=str(ticket.id)+".pdf")
			os.rename(str(ticket.id)+'.svg',"Static/tickets/"+str(ticket.id)+'.svg')
			#send email
			email.attach_file(str(ticket.id)+'.pdf')

		email.send()
		root = os.listdir(os.getcwd())

		# Remove pdf's which were used to send email
		for item in root:
			if item.endswith(".pdf"):
				os.remove( item)

		return redirect("/confirmation")

	screening = Screening.objects.filter(id=screeningId)[0]
	movie = screening.movie_id
	screen = screening.screen_id
	return render(request,'bookingChoose.html',{'nbar':'whatson','movie':movie, 'screen':screen, 'screening':screening,'form':form} )

class whatsonapi(APIView):
	@csrf_exempt
	def get(self, request):
		movies = Movie.objects.all()
		serializer = MovieSerializer(movies, many=True)
		return Response(serializer.data)

class movieTimingsapi(APIView):
	@csrf_exempt
	def get(self, request, MovieID, date):
		movie = Movie.objects.filter(id = MovieID).first()
		movie = movie.id
		#dateString = year + "-" + month + "-" + day
		date = datetime.datetime.strptime(date, "%Y-%m-%d").date()
		timing = Screening.objects.filter(movie_id = movie).filter(date = date).all()
		serializer = ScreeningSerializer(timing, many=True)
		return Response(serializer.data)


class screenapi(APIView):
	@csrf_exempt
	def get(self, request, ScreeningID):
		screening = Screening.objects.filter(id = ScreeningID).first()
		screen = screening.screen_id
		#screen = Screen.objects.filter(id = screen).first()
		serializer = ScreenSerializer(screen, many=False)
		return Response(serializer.data)

class seatingapi(APIView):
	@csrf_exempt
	def get(self, request, screeningId):
		seats = Seat.objects.filter(screening_id = screeningId).all()
		serializer = SeatSerializer(seats , many = True)
		return Response(serializer.data)
	def put(self, request, *args, **kwargs):
		return self.update(request, *args, **kwargs)
