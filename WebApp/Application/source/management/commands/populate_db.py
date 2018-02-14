from django.core.management.base import BaseCommand
from source.models import *

class Command(BaseCommand):
    args = '<foo bar ...>'
    help = 'our help string comes here'

    def handle(self, *args, **options):
        actor1 = Actor(name="actor1")
        actor1.save()
        actor2 = Actor(name="actor2")
        actor2.save()
        actor3 = Actor(name="actor3")
        actor3.save()

        movie1 = Movie(title="Django Unchained", blurb="This movie is called Django Unchained", cover="DjangoUnchained.jpg", rating= 6.7,duration="5000", director="Director1", certificate="15", releaseDate="2012-08-27")
        movie1.save()
        movie1.cast.add(actor1)
        movie1.cast.add(actor2)
        movie2 = Movie(title="Doctor Strange", blurb="This movie is called Doctor Strange", cover="DoctorStrange.jpg", rating= 6.4,duration="4600", director="Director2", certificate="12A", releaseDate="2017-02-11")
        movie2.save()
        movie2.cast.add(actor1)
        movie3 = Movie(title="Star Wars", blurb="This movie is called star wars", cover="StarWars.jpg", rating=7.2,duration="5300", director="Director3", certificate="12", releaseDate="2017-12-21")
        movie3.save()
        movie3.cast.add(actor1)
        movie3.cast.add(actor2)
        movie3.cast.add(actor3)
        movie4 = Movie(title="The Road", blurb="This movie is called the road", cover="TheRoad.jpg", rating=4.9,duration="5580", director="Director4", certificate="15", releaseDate="2016-10-09")
        movie4.save()
        movie4.cast.add(actor1)
        movie4.cast.add(actor3)
        movie5 = Movie(title="World War Z", blurb="This movie is called world war z", cover="WorldWarZ.jpg", rating=7.6,duration="5028", director="Director5", certificate="15", releaseDate="2015-07-10")
        movie5.save()
        movie5.cast.add(actor2)

        screen1 = Screen(standardSeats=50 ,vipSeats=20 )
        screen1.save()
        screen2 = Screen(standardSeats=50 ,vipSeats=20 )
        screen2.save()
        screen3 = Screen(standardSeats=50 ,vipSeats=20 )
        screen3.save()
        screen4 = Screen(standardSeats=70 ,vipSeats=30 )
        screen4.save()
        screen5 = Screen(standardSeats=70 ,vipSeats=30 )
        screen5.save()

        s1m1 = Screening(movie_id = movie1 , screen_id = screen1, reservedSeats = 0)
        s1m1.save()
        s2m1 = Screening(movie_id = movie1 , screen_id = screen1, reservedSeats = 10)
        s2m1.save()
        s3m1 = Screening(movie_id = movie1 , screen_id = screen2, reservedSeats = 3)
        s3m1.save()

        s1m2 = Screening(movie_id = movie2 , screen_id = screen2, reservedSeats = 0)
        s1m2.save()
        s2m2 = Screening(movie_id = movie2 , screen_id = screen2, reservedSeats = 10)
        s2m2.save()

        s1m3 = Screening(movie_id = movie3 , screen_id = screen3, reservedSeats = 0)
        s1m3.save()
        s2m3 = Screening(movie_id = movie3 , screen_id = screen3, reservedSeats = 40)
        s2m3.save()
        s3m3 = Screening(movie_id = movie3 , screen_id = screen3, reservedSeats = 23)
        s3m3.save()

        s1m4 = Screening(movie_id = movie4 , screen_id = screen4, reservedSeats = 0)
        s1m4.save()
        s2m4 = Screening(movie_id = movie4 , screen_id = screen4, reservedSeats = 16)
        s2m4.save()

        s1m5 = Screening(movie_id = movie5 , screen_id = screen5, reservedSeats = 0)
        s1m5.save()

        t1m1 = Timing(screening_id = s1m1, date = '2018-02-15' , time = '11:20:00' )
        t1m1.save()
        t2m1 = Timing(screening_id = s2m1, date = '2018-02-15' , time = '16:20:00' )
        t2m1.save()
        t3m1 = Timing(screening_id = s3m1, date = '2018-02-16', time = '19:20:00')
        t3m1.save()

        t1m2 = Timing(screening_id = s1m2, date = '2018-02-15', time = '15:55:00')
        t1m2.save()
        t2m2 = Timing(screening_id = s2m2, date = '2018-02-16', time = '12:50:00')
        t2m2.save()

        t1m3 = Timing(screening_id = s1m3, date = '2018-02-15', time = '11:00:00')
        t1m3.save()
        t2m3 = Timing(screening_id = s2m3, date = '2018-02-15', time = '18:10:00')
        t2m3.save()
        t3m3 = Timing(screening_id = s3m3, date = '2018-02-15', time = '17:25:00')
        t3m3.save()

        t1m4 = Timing(screening_id = s1m4, date = '2018-02-16', time = '14:15:00')
        t1m4.save()
        t2m4 = Timing(screening_id = s2m4, date = '2018-02-16', time = '20:00:00')
        t2m4.save()

        t1m5 = Timing(screening_id = s1m5, date = '2018-02-15', time = '15:40:00')
        t1m5.save()
