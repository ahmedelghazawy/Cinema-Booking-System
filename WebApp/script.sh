DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"

echo $DIR

module add python

pip install virtualenv

virtualenv $DIR/env

source $DIR/env/bin/activate

pip install django

cd $DIR/Application/

python manage.py makemigrations

python manage.py migrate

python manage.py populate_db

python manage.py migrate

python manage.py runserver
