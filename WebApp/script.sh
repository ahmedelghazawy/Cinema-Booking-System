pip install virtualenv

virtualenv env

source env/bin/activate

pip install django

cd Application/

python manage.py makemigrations

python manage.py migrate


python PopulateDatabase.py

python manage.py migrate

python manage.py runserver
