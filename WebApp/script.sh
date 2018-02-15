module load python

pip install virtualenv

virtualenv env

source env/bin/activate

pip install django

cd Application/

python manage.py makemigrations

python manage.py migrate

python manage.py populate_db

python manage.py migrate

python manage.py runserver
