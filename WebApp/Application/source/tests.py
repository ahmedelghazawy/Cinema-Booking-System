import os
import unittest
import tempfile


class Tests(unittest.TestCase):
    # Create your tests here.
    # testing index page loads
    def test_index(self):
        response = self.app.get('/', follow_redirects=True, content_type='html/text')
        self.assertEqual(response.status_code, 200)


    # tests index page is correct
    def test_home_text1(self):
        response = self.app.get('/index', follow_redirects=True)
        self.assertIn(b'New Releases',response.data)

    def test_home_text2(self):
        response = self.app.get('/index', follow_redirects=True)
        self.assertIn(b'New Releases',response.data)


    # testing whats page loads
    def test_whatson(self):
        response = self.app.get('/whatson', follow_redirects=True, content_type='html/text')
        self.assertEqual(response.status_code, 200)

    # main
if __name__ == '__main__':
    unittest.main()
