from django.db import models
import datetime

class User(models.Model):
	name = models.CharField(max_length = 200)
	email = models.EmailField(unique=True)
	password = models.CharField(max_length = 200)
	cardNo = models.CharField(blank=True, null=True, max_length = 16)
	nameOnCard = models.CharField(blank=True, null=True, max_length = 100)
	expirationMonth = models.CharField(blank=True, null=True, max_length = 2)
	expirationYear = models.CharField(blank=True, null=True, max_length = 2)


class Actor(models.Model):
	name = models.CharField(max_length = 200)

class Movie(models.Model):
	title = models.CharField(max_length = 150)
	blurb = models.TextField(max_length = 2000)
	cover = models.TextField(max_length = 500)
	rating = models.FloatField()
	duration = models.IntegerField()
	director = models.CharField(max_length = 200)
	certificate = models.CharField(max_length = 150)
	releaseDate = models.DateField(auto_now_add=False)
	cast = models.ManyToManyField(Actor)

class Screen(models.Model):
	standardSeats = models.IntegerField()
	vipSeats = models.IntegerField()

class Screening(models.Model):
	movie_id = models.ForeignKey('Movie',on_delete=models.CASCADE,)
	screen_id = models.ForeignKey('Screen',on_delete=models.CASCADE,)
	date = models.DateField(auto_now_add=False, null=True)
	time = models.TimeField(auto_now_add=False, null=True)

class Seat(models.Model):
	screening_id = models.ForeignKey('Screening',on_delete=models.CASCADE, default="")
	vipSeat = models.BooleanField(default=False)
	row = models.IntegerField()
	column = models.IntegerField()



class Ticket(models.Model):
	movie_id = models.ForeignKey('Movie',on_delete=models.CASCADE,)
	screening_id = models.ForeignKey('Screening',on_delete=models.CASCADE, default="")
	seat_id = models.ForeignKey('Seat',on_delete=models.CASCADE,)
	user_id = models.ForeignKey('User',on_delete=models.CASCADE,)
