from django.conf.urls import url, include
from . import views

urlpatterns = [
    url(r'^$', views.index, name = 'index'),
    url(r'^test2$', views.test2, name = 'test2'),
    url(r'^whatson$', views.whatson, name = 'whatson'),
    url(r'^moviePage/(?P<MovieID>\d+)/$', views.moviePage, name = 'moviePage'),
]
