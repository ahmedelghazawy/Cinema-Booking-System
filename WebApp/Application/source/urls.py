from django.conf.urls import url, include
from rest_framework.urlpatterns import format_suffix_patterns
from . import views

urlpatterns = [
    url(r'^$', views.index, name = 'index'),
    url(r'^whatson$', views.whatson, name = 'whatson'),
    url(r'^api/whatsonapi$', views.whatsonapi.as_view()),
    url(r'^api/movieTimingsapi/(?P<MovieID>\d+)/(?P<date>[\w\-]+)/$', views.movieTimingsapi.as_view()),
    #url(r'^test2$', views.test2.as_view()),
    url(r'^moviePage/(?P<MovieID>\d+)/$', views.moviePage, name = 'moviePage'),
]

urlpatterns = format_suffix_patterns(urlpatterns)
