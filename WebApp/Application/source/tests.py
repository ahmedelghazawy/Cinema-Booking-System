from django.test import TestCase
import os
import unittest
import tempfile
from app import *
from app.models import *

# Create your tests here.

    # testing index page loads
    def test_index(self):
        response = self.app.get('/', follow_redirects=True, content_type='html/text')
        self.assertEqual(response.status_code, 200)


    # tests index page is correct
    def test_loginPageLoads(self):
        response = self.app.get('/index', follow_redirects=True)
        self.assertIn(b'New Releases',response.data)

# commit
