#!/bin/sh
DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"

echo $DIR

rm database.db -f

module add python

pip install virtualenv

virtualenv $DIR/env

source $DIR/env/bin/activate

pip install django

pip install djangorestframework

pip install django-filter

pip install pyqrcode

pip3 install cairosvg

pip install schedule

cd $DIR/Application/

if [[ $1 == "devel" ]]
then
	echo "Running DEVELOPMENT session"

else
	echo "Running NORMAL session"

	python manage.py makemigrations

	python manage.py migrate

	python manage.py populate_db

	python manage.py makemigrations

	python manage.py migrate

	while true; do sleep 15; python manage.py clear_unconf ; done &

	python manage.py runserver

fi
