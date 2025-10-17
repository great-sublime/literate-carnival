PYTHON programming language for backend

VARIABLES:
name = "John"
age = 30
price = 15000.50
is_available = True

DATA STRUCTURES:
list = ["Toyota", "Honda", "Ford"]
tuple = ("red", "blue", "green") # immutable
dictionary = {"make": "Toyota", "model": "Corolla"}
set = {"sedan", "suv", "truck"} # unique values

FUNCTIONS:
def calculate_tax(price):
tax_rate = 0.13
return price * tax_rate

CLASSES:
class Vehicle:
def __init__(self, make, model, year):
self.make = make
self.model = model
self.year = year

def get_age(self):
return 2024 - self.year

DJANGO web framework

PROJECT STRUCTURE:
myproject/
manage.py
myproject/
settings.py
urls.py
wsgi.py
vehicles/
models.py
views.py
urls.py
admin.py

MODELS (database tables):
from django.db import models

class Vehicle(models.Model):
MAKE_CHOICES = [
('TOYOTA', 'Toyota'),
('HONDA', 'Honda'),
('FORD', 'Ford'),
]
make = models.CharField(max_length=20, choices=MAKE_CHOICES)
model = models.CharField(max_length=50)
year = models.IntegerField()
price = models.DecimalField(max_digits=10, decimal_places=2)
description = models.TextField(blank=True)
is_available = models.BooleanField(default=True)
created_at = models.DateTimeField(auto_now_add=True)

def __str__(self):
return f"{self.year} {self.make} {self.model}"

VIEWS (request handlers):
from django.shortcuts import render
from .models import Vehicle

def vehicle_list(request):
vehicles = Vehicle.objects.filter(is_available=True)
return render(request, 'vehicles/list.html', {'vehicles': vehicles})

def search_vehicles(request):
make = request.GET.get('make')
max_price = request.GET.get('max_price')
vehicles = Vehicle.objects.filter(is_available=True)
if make:
vehicles = vehicles.filter(make=make)
if max_price:
vehicles = vehicles.filter(price__lte=max_price)
return render(request, 'vehicles/search_results.html', {'vehicles': vehicles})

URLS (routing):
from django.urls import path
from . import views

urlpatterns = [
path('vehicles/', views.vehicle_list, name='vehicle_list'),
path('search/', views.search_vehicles, name='vehicle_search'),
]

DJANGO ADMIN:
from django.contrib import admin
from .models import Vehicle

@admin.register(Vehicle)
class VehicleAdmin(admin.ModelAdmin):
list_display = ['make', 'model', 'year', 'price', 'is_available']
list_filter = ['make', 'year', 'is_available']
search_fields = ['model', 'description']

FORMS:
from django import forms
from .models import Vehicle

class VehicleForm(forms.ModelForm):
class Meta:
model = Vehicle
fields = ['make', 'model', 'year', 'price', 'description']
widgets = {
'description': forms.Textarea(attrs={'rows': 4}),
}

AUTHENTICATION:
from django.contrib.auth.decorators import login_required

@login_required
def add_vehicle(request):
if request.method == 'POST':
form = VehicleForm(request.POST)
if form.is_valid():
vehicle = form.save(commit=False)
vehicle.owner = request.user
vehicle.save()
return redirect('vehicle_list')
else:
form = VehicleForm()
return render(request, 'vehicles/add.html', {'form': form})

DJANGO REST FRAMEWORK for APIs:
from rest_framework import viewsets
from .models import Vehicle
from .serializers import VehicleSerializer

class VehicleViewSet(viewsets.ModelViewSet):
queryset = Vehicle.objects.filter(is_available=True)
serializer_class = VehicleSerializer

def get_queryset(self):
queryset = Vehicle.objects.filter(is_available=True)
make = self.request.query_params.get('make')
if make:
queryset = queryset.filter(make=make)
return queryset