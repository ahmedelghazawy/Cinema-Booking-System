from django.conf.urls import url, include
from django.conf.urls.static import static
from rest_framework.urlpatterns import format_suffix_patterns
from . import views
from django.conf import settings

urlpatterns = [
    url(r'^$', views.index, name = 'index'),
    url(r'^whatson$', views.whatson, name = 'whatson'),
    url(r'^download/(?P<ticketID>\d+)/$', views.download, name = 'download'),
	url(r'^confirmation$', views.confirmation, name = 'confirmation'),
    url(r'^login$', views.loginPage, name = 'loginPage'),
    url(r'^logout$', views.logoutPage, name = 'logoutPage'),
    url(r'^register$', views.registerPage, name = 'registerPage'),
    url(r'^profile$', views.profilePage, name = 'profilePage'),
    url(r'^checkout$', views.checkoutPage, name = 'checkoutPage'),
    url(r'^search$', views.search, name = 'search'),
    url(r'^confirmation$', views.confirmation, name = 'confirmation'),
    url(r'^api/whatsonapi$', views.whatsonapi.as_view()),
    url(r'^api/movieTimingsapi/(?P<MovieID>\d+)/(?P<date>[\w\-]+)/$', views.movieTimingsapi.as_view()),
    url(r'^api/seatingapi/(?P<screeningId>\d+)/$', views.seatingapi.as_view()),
    #url(r'^test2$', views.test2.as_view()),
    url(r'^api/screenapi/(?P<screeningId>\d+)/$', views.screenapi.as_view()),
    url(r'^moviePage/(?P<MovieID>\d+)/$', views.moviePage, name = 'moviePage'),
	url(r'^bookingChoose/(?P<screeningId>\d+)/$', views.bookingChoose, name = 'bookingChoose'),
	url(r'^bookingChoose$', views.bookingChoose, name = 'bookingChoose'),
]

urlpatterns = format_suffix_patterns(urlpatterns)
