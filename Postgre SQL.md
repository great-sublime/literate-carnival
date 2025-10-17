POSTGRESQL relational database

BASIC COMMANDS:
CREATE DATABASE vehicle_platform;
\c vehicle_platform connect to database
\l list databases
\dt list tables

CREATE TABLES:
CREATE TABLE vehicles (
id SERIAL PRIMARY KEY,
make VARCHAR(50) NOT NULL,
model VARCHAR(50) NOT NULL,
year INTEGER NOT NULL,
price DECIMAL(10,2),
description TEXT,
is_available BOOLEAN DEFAULT TRUE,
created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE users (
id SERIAL PRIMARY KEY,
username VARCHAR(50) UNIQUE NOT NULL,
email VARCHAR(100) UNIQUE NOT NULL,
password_hash VARCHAR(255) NOT NULL,
phone VARCHAR(20),
created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE repairs (
id SERIAL PRIMARY KEY,
vehicle_id INTEGER REFERENCES vehicles(id),
workshop_id INTEGER REFERENCES workshops(id),
description TEXT NOT NULL,
cost DECIMAL(8,2),
status VARCHAR(20) DEFAULT 'pending',
created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

BASIC QUERIES:
SELECT * FROM vehicles;
SELECT make, model, price FROM vehicles WHERE year > 2020;
SELECT make, COUNT(*) FROM vehicles GROUP BY make;
INSERT INTO vehicles (make, model, year, price) VALUES ('Toyota', 'Corolla', 2020, 15000);
UPDATE vehicles SET price = 14500 WHERE id = 1;
DELETE FROM vehicles WHERE id = 1;

JOINS for related data:
SELECT v.make, v.model, r.description, r.cost
FROM vehicles v
JOIN repairs r ON v.id = r.vehicle_id
WHERE v.make = 'Toyota';

INDEXES for performance:
CREATE INDEX idx_vehicles_make ON vehicles(make);
CREATE INDEX idx_vehicles_price ON vehicles(price);
CREATE INDEX idx_vehicles_year ON vehicles(year);

DJANGO DATABASE CONFIG in settings.py:
DATABASES = {
'default': {
'ENGINE': 'django.db.backends.postgresql',
'NAME': 'vehicle_platform',
'USER': 'your_username',
'PASSWORD': 'your_password',
'HOST': 'localhost',
'PORT': '5432',
}
}

DATABASE MIGRATIONS:
python manage.py makemigrations create migration files
python manage.py migrate apply migrations
python manage.py createsuperuser create admin user

BACKUP AND RESTORE:
pg_dump vehicle_platform > backup.sql backup database
psql vehicle_platform < backup.sql restore database

USEFUL QUERIES FOR VEHICLE PLATFORM:

Average price by make:
SELECT make, AVG(price) as avg_price 
FROM vehicles 
WHERE is_available = true 
GROUP BY make 
ORDER BY avg_price DESC;

Popular models:
SELECT make, model, COUNT(*) as count
FROM vehicles
GROUP BY make, model
ORDER BY count DESC
LIMIT 10;

Price statistics:
SELECT 
MIN(price) as min_price,
MAX(price) as max_price,
AVG(price) as avg_price,
PERCENTILE_CONT(0.5) WITHIN GROUP (ORDER BY price) as median_price
FROM vehicles
WHERE is_available = true;

Search with multiple criteria:
SELECT * FROM vehicles
WHERE is_available = true
AND make = 'Toyota'
AND year BETWEEN 2018 AND 2022
AND price <= 20000
ORDER BY price ASC;