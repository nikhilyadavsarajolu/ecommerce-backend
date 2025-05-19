# E-Commerce Backend API

This is a Spring Boot-based backend for an e-commerce application. It provides a RESTful API for user authentication, product management, and cart operations with JWT-based security.

## Features

- User Registration & Login (JWT Auth)
- Product CRUD (Create, Read, Update, Delete)
- Cart Management (Add, View, Remove Products)
- Secure password storage using BCrypt
- MySQL database integration

## Tech Stack

- Java 17
- Spring Boot
- Spring Security + JWT
- Spring Data JPA + Hibernate
- MySQL
- Lombok

## Setup Instructions

1. **Clone the repository**
   ```bash
   git clone https://github.com/nikhilyadavsarajolu/ecommerce-backend.git
   cd ecommerce-backend


2. Set up MySQL database

Create a database:

CREATE DATABASE ecommerce;

Update your application.properties with MySQL credentials.



3. Run the project

mvn spring-boot:run



API Endpoints

Authentication

POST /api/auth/register

POST /api/auth/login


Product

POST /api/products

GET /api/products

GET /api/products/{id}

PUT /api/products/{id}

DELETE /api/products/{id}


Cart

POST /api/cart/add

GET /api/cart/view

DELETE /api/cart/remove/{productId}


Author

Nikhil Yadav


License

This project is for educational purposes only.