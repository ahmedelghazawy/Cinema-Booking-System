import os
import unittest
import tempfile
from django.test import TestCase
from django.test import Client
from django.urls import reverse
from django.db import models

from django.contrib.auth.models import User

class error200(TestCase):
	# Create your tests here.
#------------------------ testing if pages load -------------------------#
	def test_homepage(self):
		response = self.client.get('/')
		self.assertEqual(response.status_code, 200)

	def test_pageNotfound1(self):
		response = self.client.get('/idontexist')
		self.assertEqual(response.status_code, 404)

	def test_pageNotfound2(self):
		response = self.client.get('/AliIsTheBest')
		self.assertEqual(response.status_code, 404)

	def test_whatson(self):
		response = self.client.get('/whatson')
		self.assertEqual(response.status_code, 200)

	def test_login(self):
		response = self.client.get('/login')
		self.assertEqual(response.status_code, 200)

	def test_register(self):
		response = self.client.get('/register')
		self.assertEqual(response.status_code, 200)

	def test_profile_redirect(self):
		response = self.client.get('/profile')
		self.assertEqual(response.status_code, 302)


	def test_confirmation(self):
		response = self.client.get('/confirmation')
		self.assertEqual(response.status_code, 200)

	def test_search(self):
		response = self.client.get('/search')
		self.assertEqual(response.status_code, 200)

	def test_confirmation(self):
		response = self.client.get('/confirmation')
		self.assertEqual(response.status_code, 200)

		def test_checkout(self):
			response = self.client.get('/checkout')
			self.assertEqual(response.status_code, 404)

	def test_moviePageNo(self):
		response = self.client.get('/moviePage/')
		self.assertEqual(response.status_code, 404)

	def test_moviePageNoId(self):
		response = self.client.get('/moviePage/7')
		self.assertEqual(response.status_code, 301)



##------------ loading the right pages ----------##

###Index
	def test_content_index(self):
		response = self.client.get('/')
		self.assertContains(response, '<h1>Newest releases</h1>')

	def test_notcontent_index(self):
		response = self.client.get('/')
		self.assertNotContains(response, '<h1>deadest releases</h1>')

	def test_content_index1(self):
		response = self.client.get('/')
		self.assertContains(response, '<h4>Site map</h4>')

	def test_content_index2(self):
		response = self.client.get('/')
		self.assertContains(response, '<p>Check what new movies have appeared in our cinema this week</p>')

	def test_notcontent_index2(self):
		response = self.client.get('/')
		self.assertNotContains(response, '<p>Michal is a great programmer<p>')


##whats on
	def test_content_whatsOn(self):
		response = self.client.get('/whatson')
		self.assertContains(response, '<h1 style="margin:30px 0 50px 0">Currently Showing</h1>')


	def test_NotContent_whatsOn(self):
		response = self.client.get('/whatson')
		self.assertNotContains(response, '<h2 style="margin:30px 0 20px 0">Currently not testing</h2>')

##login
	# def test_content_login1(self):
	# 	response = self.client.get('/login')
	# 	self.assertContains(response, '<a href="/login">Login | Register </a>')

	def test_content_login2(self):
		response = self.client.get('/login')
		self.assertContains(response, '<label for="remember"> Remember Me</label>')


	def test_NotContent_login1(self):
		response = self.client.get('/login')
		self.assertNotContains(response, '<a href="/dfds">aLOO  </a>')

	def test_NotContent_login2(self):
		response = self.client.get('/login')
		self.assertNotContains(response, '<section for="remember"> dfsdkfsdlkj </section>')

## Register
##
	def test_content_register1(self):
		response = self.client.get('/register')
		self.assertContains(response, '<h4>About Toucan</h4>')

	def test_NotContent_register1(self):
		response = self.client.get('/register')
		self.assertNotContains(response, '<h4>Hoos</h4>')


## Confirmation
	def test_content_confirmation1(self):
		response = self.client.get('/confirmation')
		self.assertContains(response, '<h1>Success</h1>')

	def test_content_confirmation2(self):
		response = self.client.get('/confirmation')
		self.assertContains(response, '<h4>Card Transcation has been processed</h4>')

	def test_NotContent_confirmation1(self):
		response = self.client.get('/confirmation')
		self.assertNotContains(response, '<h3>Fail</h3>')

	def test_NotContent_confirmation2(self):
		response = self.client.get('/confirmation')
		self.assertNotContains(response, '<h1>Card Transcation fail</h1>')





##header

##foote
