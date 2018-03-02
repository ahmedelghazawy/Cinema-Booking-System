from django.core.management.base import BaseCommand
from source.models import *
import datetime
import random
import math

class Command(BaseCommand):
	args = 'accepts no arguments'
	help = "Commands the databse with relation to Today's date"

	############# Settings ##############
	today = datetime.date.today()
	screeningsPerWeek = [30,20,15,10,5,2,0]
	movieDuration = 150


	# Shifts the date from today to given number of days
	def getReleaseDate(noOfDays):
		return Command.today + datetime.timedelta(days=noOfDays)

	def getScreenings(movie):
		diff = (movie.releaseDate - Command.today).days
		week = math.floor(diff/7)*(-1)
		if week > 5:
			week = 5
		return Command.screeningsPerWeek[week]

	def handle(self, *args, **options):

############# Actors ################
		actors = []
		actors.append(Actor(name = "Hugh Jackman"))
		actors.append(Actor(name = "Zac Effron"))
		actors.append(Actor(name = "Zendaya Coleman"))
		actors.append(Actor(name = "Chadwick Boseman"))
		actors.append(Actor(name = "Michael B. Jordan"))
		actors.append(Actor(name = "Lupito Nyong'o"))
		actors.append(Actor(name = "Anthony Gonazalez"))
		actors.append(Actor(name = "Gael García Bernal"))
		actors.append(Actor(name = "Benjamin Bratt"))
		actors.append(Actor(name = "Tom Hiddleston"))
		actors.append(Actor(name = "Eddie Redmayne"))
		actors.append(Actor(name = "Maisie Williams"))
		actors.append(Actor(name = "Sally Hawkins"))
		actors.append(Actor(name = "Doug Jones"))
		actors.append(Actor(name = "Michael Shannon"))
		actors.append(Actor(name = "Jamie Dornan"))
		actors.append(Actor(name = "Dakota Johnson"))
		actors.append(Actor(name = "Rita Ora"))
		actors.append(Actor(name = "Meryl Streep"))
		actors.append(Actor(name = "Tom Hanks"))
		actors.append(Actor(name = "Alison Brie"))
		actors.append(Actor(name = "Dylan O'Brien"))
		actors.append(Actor(name = "Ki Hong Lee"))
		actors.append(Actor(name = "Kaya Scodelario"))
		actors.append(Actor(name = "Rachel Weisz"))
		actors.append(Actor(name = "Colin Firth"))
		actors.append(Actor(name = "David Thewlis"))
		actors.append(Actor(name = "Liam Neeson"))
		actors.append(Actor(name = "Vera Farmiga"))
		actors.append(Actor(name = "Patrick Wilson"))

		#Save actors
		for actor in actors:
			actor.save()

		################### Movies ######################
		movies = []

		movies.append(Movie(title = "The Greates Showman", blurb = "Celebrates the birth of show business, and tells of a visionary who rose from nothing to create a spectacle that became a worldwide sensation.", cover = "img/MovieCovers/TheGreatestShowman.jpg", rating =  8.0 ,duration = "139", director = "Michael Gracey", certificate = "0", releaseDate = Command.getReleaseDate(-25)))
		movies.append(Movie(title = "Black Panther", blurb = "T'Challa, after the death of his father, the King of Wakanda, returns home to the isolated, technologically advanced African nation to succeed to the throne and take his rightful place as king.", cover = "img/MovieCovers/BlackPanther.jpg", rating =  7.1 ,duration = "134", director = "Ryan Coogler", certificate = "12A", releaseDate =  Command.getReleaseDate(-10)))
		movies.append(Movie(title = "Coco", blurb = "Aspiring musician Miguel, confronted with his family's ancestral ban on music, enters the Land of the Dead to find his great-great-grandfather, a legendary singer.", cover = "img/MovieCovers/Coco.jpg", rating = 8.6  ,duration = "105", director = "Lee Unkrich, Adrian Molina", certificate = "0", releaseDate =  Command.getReleaseDate(-15)))
		movies.append(Movie(title = "Early Man", blurb = "Set at the dawn of time, when prehistoric creatures and woolly mammoths roamed the earth, Early Man tells the story of Dug, along with sidekick Hognob as they unite his tribe against a mighty enemy Lord Nooth and his Bronze Age City to save their home.", cover = "img/MovieCovers/EarlyMan.jpg", rating = 6.4  ,duration = "99", director = "Nick Park", certificate = "0", releaseDate =  Command.getReleaseDate(-5)))
		movies.append(Movie(title = "The Shape of Water", blurb = "At a top secret research facility in the 1960s, a lonely janitor forms a unique relationship with an amphibious creature that is being held in captivity.", cover = "img/MovieCovers/TheShapeOfWater.jpg", rating = 7.8  ,duration = "123", director = "Guillermo der Toro", certificate = "R", releaseDate =  Command.getReleaseDate(0)))
		movies.append(Movie(title = "Fifty Shades Freed", blurb = "Anastasia and Christian get married, but Jack Hyde continues to threaten their relationship.", cover = "img/MovieCovers/FiftyShadesFreed.jpg", rating = 4.2  ,duration = "105", director = "James Foley", certificate = "R", releaseDate =  Command.getReleaseDate(-8)))
		movies.append(Movie(title = "The Post", blurb = "A cover-up that spanned four U.S. Presidents pushed the country's first female newspaper publisher and a hard-driving editor to join an unprecedented battle between the press and the government.", cover = "img/MovieCovers/ThePost.jpg", rating = 7.3  ,duration = "116", director = "Steven Spielberg", certificate = "13", releaseDate =  Command.getReleaseDate(-12)))
		movies.append(Movie(title = "Maze Runner: The Death Cure", blurb = "Young hero Thomas embarks on a mission to find a cure for a deadly disease known as the 'Flare'.", cover = "img/MovieCovers/MazeRunnerTheDeathCure.jpg", rating = 6.9  ,duration = "141", director = "Wes Ball", certificate = "13", releaseDate =  Command.getReleaseDate(-3)))
		movies.append(Movie(title = "The Mercy", blurb = "The incredible story of amateur sailor Donald Crowhurst and his solo attempt to circumnavigate the globe. The struggles he confronted on the journey while his family awaited his return is one of the most enduring mysteries of recent times.", cover = "img/MovieCovers/TheMercy.jpg", rating = 6.3  ,duration = "101", director = "James Marsh", certificate = "0", releaseDate =  Command.getReleaseDate(-18)))
		movies.append(Movie(title = "The Commuter", blurb = "A businessman is caught up in a criminal conspiracy during his daily commute home.", cover = "img/MovieCovers/TheCommuter.jpg", rating = 6.5  ,duration = "105", director = "Jaume Collet-Serra", certificate = "13", releaseDate =  Command.getReleaseDate(-7)))

		for movie in movies:
			movie.save()

		movies[0].cast.add(actors[0])
		movies[0].cast.add(actors[1])
		movies[0].cast.add(actors[2])
		movies[1].cast.add(actors[3])
		movies[1].cast.add(actors[4])
		movies[1].cast.add(actors[5])
		movies[2].cast.add(actors[6])
		movies[2].cast.add(actors[7])
		movies[2].cast.add(actors[8])
		movies[3].cast.add(actors[9])
		movies[3].cast.add(actors[10])
		movies[3].cast.add(actors[11])
		movies[4].cast.add(actors[12])
		movies[4].cast.add(actors[13])
		movies[4].cast.add(actors[14])
		movies[5].cast.add(actors[15])
		movies[5].cast.add(actors[16])
		movies[5].cast.add(actors[17])
		movies[6].cast.add(actors[18])
		movies[6].cast.add(actors[19])
		movies[6].cast.add(actors[20])
		movies[7].cast.add(actors[21])
		movies[7].cast.add(actors[22])
		movies[7].cast.add(actors[23])
		movies[8].cast.add(actors[24])
		movies[8].cast.add(actors[25])
		movies[8].cast.add(actors[26])
		movies[9].cast.add(actors[27])
		movies[9].cast.add(actors[28])
		movies[9].cast.add(actors[29])

####################### Screens #######################

		screens = []

		screens.append(Screen(standardSeats = 50 ,vipSeats = 20 ))
		screens.append(Screen(standardSeats = 50 ,vipSeats = 20 ))
		screens.append(Screen(standardSeats = 50 ,vipSeats = 20 ))
		screens.append(Screen(standardSeats = 70 ,vipSeats = 30 ))
		screens.append(Screen(standardSeats = 70 ,vipSeats = 30 ))

		for screen in screens:
			screen.save()

###################### Screenings ######################

		# Data to be inserted into the database
		# Key = index of movie object in movies
		# Value = index of screenobject in screens
		screenings_data = {}

		screenings = []
		for movie in movies:
			amount = Command.getScreenings(movie)
			for num in range(amount):
				screenings.append(Screening(
				movie_id = movie,
				screen_id = screens[random.sample(range(0, 4),1)[0]],
				date = Command.today + datetime.timedelta(days=random.sample(range(0,6),1)[0]),
				time = datetime.time(hour = random.sample(range(4,11),1)[0]*2)))

		for scr in screenings:
			scr.save()
		#screenings_data={0:"0,2,4",1:"1,3",2:"0",3:"1,3,4,2",4:"0,4",5:"2,4",6:"0,1,2",7:"3,4",8:"2,1",9:"3"}
		# print(screenings)
		#
		#
		#
		# # Inserting data
		# # Loop trought the screenings_data for each movie and its' screenings
		# for screening in screenings_data.items():
		# 	# Get the id of currently processed movie
		# 	moveId = screening[0]
		# 	totalScreenings = screening[1]
		# 	# days in each screening
		#
		# 	# For each screening for that movie
		# 	for screen in screening[1]:
		#
		# 		screenings.append(Screening(movie_id = movieId, screen_id = screens[int(screen)].id, date, time))
		#
		# # Save screenings


		# s1m1 = Screening(movie_id = movie1 , screen_id = screen1 )
		# s1m1.save()
		# s2m1 = Screening(movie_id = movie1 , screen_id = screen4 )
		# s2m1.save()
		# s3m1 = Screening(movie_id = movie1 , screen_id = screen5 )
		# s3m1.save()

		# s1m2 = Screening(movie_id = movie2 , screen_id = screen2 )
		# s1m2.save()
		# s2m2 = Screening(movie_id = movie2 , screen_id = screen5 )
		# s2m2.save()

		# s1m3 = Screening(movie_id = movie3 , screen_id = screen1 )
		# s1m3.save()
		# s2m3 = Screening(movie_id = movie3 , screen_id = screen2 )
		# s2m3.save()
		# s3m3 = Screening(movie_id = movie3 , screen_id = screen3 )
		# s3m3.save()

		# s1m4 = Screening(movie_id = movie4 , screen_id = screen2 )
		# s1m4.save()
		# s2m4 = Screening(movie_id = movie4 , screen_id = screen5 )
		# s2m4.save()

		# s1m5 = Screening(movie_id = movie5 , screen_id = screen1 )
		# s1m5.save()

		# s1m6 = Screening(movie_id = movie6 , screen_id = screen3 )
		# s1m6.save()
		# s2m6 = Screening(movie_id = movie6 , screen_id = screen4 )
		# s2m6.save()

		# s1m7 = Screening(movie_id = movie7 , screen_id = screen5 )
		# s1m7.save()
		# s2m7 = Screening(movie_id = movie7 , screen_id = screen2 )
		# s2m7.save()

		# s1m8 = Screening(movie_id = movie8 , screen_id = screen1 )
		# s1m8.save()
		# s2m8 = Screening(movie_id = movie8 , screen_id = screen4 )
		# s2m8.save()

		# s1m9 = Screening(movie_id = movie9 , screen_id = screen5 )
		# s1m9.save()
		# s2m9 = Screening(movie_id = movie9, screen_id = screen3 )
		# s2m9.save()

		# s1m10 = Screening(movie_id = movie10 , screen_id = screen2 )
		# s1m10.save()
		# s2m10 = Screening(movie_id = movie10 , screen_id = screen1 )
		# s2m10.save()

############################ Timings ######################

		#
		# t1m1 = Timing(screening_id = s1m1, date = '2018-02-15' , time = '11:20:00' )
		# t1m1.save()
		# t1m1 = Timing(screening_id = s1m1, date = '2018-02-15' , time = '15:20:00' )
		# t1m1.save()
		# t1m1 = Timing(screening_id = s1m1, date = '2018-02-15' , time = '18:20:00' )
		# t1m1.save()
		# t2m1 = Timing(screening_id = s2m1, date = '2018-02-15' , time = '16:20:00' )
		# t2m1.save()
		# t2m1 = Timing(screening_id = s2m1, date = '2018-02-15' , time = '11:40:00' )
		# t2m1.save()
		# t2m1 = Timing(screening_id = s2m1, date = '2018-02-15' , time = '17:30:00' )
		# t2m1.save()
		# t3m1 = Timing(screening_id = s3m1, date = '2018-02-16', time = '12:20:00')
		# t3m1.save()
		# t3m1 = Timing(screening_id = s3m1, date = '2018-02-16', time = '19:50:00')
		# t3m1.save()
		# t3m1 = Timing(screening_id = s3m1, date = '2018-02-16', time = '16:40:00')
		# t3m1.save()
		#
		# t1m2 = Timing(screening_id = s1m2, date = '2018-02-15', time = '15:55:00')
		# t1m2.save()
		# t1m2 = Timing(screening_id = s1m2, date = '2018-02-15', time = '18:55:00')
		# t1m2.save()
		# t1m2 = Timing(screening_id = s1m2, date = '2018-02-15', time = '20:55:00')
		# t1m2.save()
		# t2m2 = Timing(screening_id = s2m2, date = '2018-02-16', time = '12:50:00')
		# t2m2.save()
		# t2m2 = Timing(screening_id = s2m2, date = '2018-02-16', time = '16:50:00')
		# t2m2.save()
		# t2m2 = Timing(screening_id = s2m2, date = '2018-02-16', time = '19:50:00')
		# t2m2.save()
		#
		# t1m3 = Timing(screening_id = s1m3, date = '2018-02-15', time = '09:00:00')
		# t1m3.save()
		# t1m3 = Timing(screening_id = s1m3, date = '2018-02-15', time = '11:15:00')
		# t1m3.save()
		# t1m3 = Timing(screening_id = s1m3, date = '2018-02-15', time = '15:00:00')
		# t1m3.save()
		# t2m3 = Timing(screening_id = s2m3, date = '2018-02-15', time = '18:10:00')
		# t2m3.save()
		# t2m3 = Timing(screening_id = s2m3, date = '2018-02-15', time = '14:10:00')
		# t2m3.save()
		# t2m3 = Timing(screening_id = s2m3, date = '2018-02-15', time = '09:35:00')
		# t2m3.save()
		# t3m3 = Timing(screening_id = s3m3, date = '2018-02-15', time = '17:25:00')
		# t3m3.save()
		# t3m3 = Timing(screening_id = s3m3, date = '2018-02-15', time = '21:25:00')
		# t3m3.save()
		# t3m3 = Timing(screening_id = s3m3, date = '2018-02-15', time = '22:55:00')
		# t3m3.save()
		#
		# t1m4 = Timing(screening_id = s1m4, date = '2018-02-16', time = '10:10:00')
		# t1m4.save()
		# t1m4 = Timing(screening_id = s1m4, date = '2018-02-16', time = '20:15:00')
		# t1m4.save()
		# t1m4 = Timing(screening_id = s1m4, date = '2018-02-16', time = '14:15:00')
		# t1m4.save()
		# t2m4 = Timing(screening_id = s2m4, date = '2018-02-16', time = '20:00:00')
		# t2m4.save()
		# t3m4 = Timing(screening_id = s2m4, date = '2018-02-16', time = '23:00:00')
		# t3m4.save()
		# t4m4 = Timing(screening_id = s2m4, date = '2018-02-16', time = '10:40:00')
		# t4m4.save()
		#
		# t1m5 = Timing(screening_id = s1m5, date = '2018-02-15', time = '16:45:00')
		# t1m5.save()
		# t1m5 = Timing(screening_id = s1m5, date = '2018-02-15', time = '13:40:00')
		# t1m5.save()
		# t1m5 = Timing(screening_id = s1m5, date = '2018-02-15', time = '20:40:00')
		# t1m5.save()
		#
		# t1m6 = Timing(screening_id = s1m6, date = '2018-02-15', time = '20:40:00')
		# t1m6.save()
		# t1m6 = Timing(screening_id = s1m6, date = '2018-02-15', time = '11:45:00')
		# t1m6.save()
		# t1m6 = Timing(screening_id = s1m6, date = '2018-02-15', time = '13:55:00')
		# t1m6.save()
		# t1m6 = Timing(screening_id = s2m6, date = '2018-02-15', time = '11:40:00')
		# t1m6.save()
		# t1m6 = Timing(screening_id = s2m6, date = '2018-02-15', time = '13:20:00')
		# t1m6.save()
		# t1m6 = Timing(screening_id = s2m6, date = '2018-02-15', time = '17:30:00')
		# t1m6.save()
		#
		# t1m7 = Timing(screening_id = s1m7, date = '2018-02-15', time = '20:30:00')
		# t1m7.save()
		# t1m7 = Timing(screening_id = s1m7, date = '2018-02-15', time = '18:40:00')
		# t1m7.save()
		# t1m7 = Timing(screening_id = s1m7, date = '2018-02-15', time = '13:40:00')
		# t1m7.save()
		# t1m7 = Timing(screening_id = s2m7, date = '2018-02-15', time = '11:40:00')
		# t1m7.save()
		# t1m7 = Timing(screening_id = s2m7, date = '2018-02-15', time = '10:00:00')
		# t1m7.save()
		# t1m7 = Timing(screening_id = s2m7, date = '2018-02-15', time = '19:40:00')
		# t1m7.save()
		#
		# t1m8 = Timing(screening_id = s1m8, date = '2018-02-15', time = '09:40:00')
		# t1m8.save()
		# t1m8 = Timing(screening_id = s1m8, date = '2018-02-15', time = '11:40:00')
		# t1m8.save()
		# t1m8 = Timing(screening_id = s1m8, date = '2018-02-15', time = '16:20:00')
		# t1m8.save()
		# t1m8 = Timing(screening_id = s2m8, date = '2018-02-15', time = '08:40:00')
		# t1m8.save()
		# t1m8 = Timing(screening_id = s2m8, date = '2018-02-15', time = '20:40:00')
		# t1m8.save()
		# t1m8 = Timing(screening_id = s2m8, date = '2018-02-15', time = '15:10:00')
		# t1m8.save()
		#
		# t1m9 = Timing(screening_id = s1m9, date = '2018-02-15', time = '23:40:00')
		# t1m9.save()
		# t1m9 = Timing(screening_id = s1m9, date = '2018-02-15', time = '20:40:00')
		# t1m9.save()
		# t1m9 = Timing(screening_id = s1m9, date = '2018-02-15', time = '13:40:00')
		# t1m9.save()
		# t1m9 = Timing(screening_id = s2m9, date = '2018-02-15', time = '11:20:00')
		# t1m9.save()
		# t1m9 = Timing(screening_id = s2m9, date = '2018-02-15', time = '10:10:00')
		# t1m9.save()
		# t1m9 = Timing(screening_id = s2m9, date = '2018-02-15', time = '17:20:00')
		# t1m9.save()
		#
		# t1m10 = Timing(screening_id = s1m10, date = '2018-02-15', time = '17:50:00')
		# t1m10.save()
		# t1m10 = Timing(screening_id = s1m10, date = '2018-02-15', time = '13:25:00')
		# t1m10.save()
		# t1m10 = Timing(screening_id = s1m10, date = '2018-02-15', time = '11:20:00')
		# t1m10.save()
		# t1m10 = Timing(screening_id = s2m10, date = '2018-02-15', time = '17:50:00')
		# t1m10.save()
		# t1m10 = Timing(screening_id = s2m10, date = '2018-02-15', time = '20:20:00')
		# t1m10.save()
		# t1m10 = Timing(screening_id = s2m10, date = '2018-02-15', time = '21:50:00')
		# t1m10.save()
