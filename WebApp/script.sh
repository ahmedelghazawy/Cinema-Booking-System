#!/bin/sh
DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"

echo $DIR

module add python

pip install virtualenv

virtualenv $DIR/env

source $DIR/env/bin/activate

 pip install django

pip install djangorestframework

pip install django-filter

pip install pyfpdf

cd $DIR/Application/

python manage.py makemigrations

python manage.py migrate

python manage.py populate_db

python manage.py migrate

if [ $1 == "devel" ]
then
	echo "Running DEVELOPMENT session"
else
	echo "Running NORMAL session"
	python manage.py runserver
fi
