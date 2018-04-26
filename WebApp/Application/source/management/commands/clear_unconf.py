from django.core.management.base import BaseCommand
from source.models import *
from datetime import datetime,time,timedelta
import random
import math

class Command(BaseCommand):

	args = 'accepts no arguments'
	help = "Removes the unconfirmed seats older than 10 minutes"

	############# Settings #############
	def handle(self, *args, **options):
		min10= datetime.time(datetime.now() - timedelta(minutes=10))
		print("Clearing unconfirmed seats: ", end='')
		print(Seat.objects.filter(time__lte=min10).exclude(heldFor=None).delete())
