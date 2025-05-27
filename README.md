# E-Commerce Backend API

A fully functional **E-Commerce Backend** built using **Java Spring Boot**, designed to handle product management, user registration & authentication, shopping cart, and order placement functionalities with secure JWT-based access control.

## Tech Stack

- **Language**: Java 17
- **Framework**: Spring Boot
- **Database**: MySQL
- **Authentication**: JWT (JSON Web Token)
- **ORM**: Spring Data JPA (Hibernate)
- **Build Tool**: Maven
- **API Testing**: Postman

---

## Features

### User Management
- User registration & login
- Role-based authentication using JWT
- Passwords encrypted using BCrypt

### Product Management
- Add, update, delete, and retrieve products
- Accessible to authenticated users

### Cart Functionality
- Add products to cart
- View cart items
- Remove individual items or clear entire cart

### Order Management
- Place orders from cart
- View order history (for authenticated user)

---

## API Endpoints

### Auth
- `POST /api/auth/register` — Register a new user
- `POST /api/auth/login` — Login and receive JWT token

### Product
- `POST /api/products` — Add a new product
- `GET /api/products` — Get all products
- `PUT /api/products/{id}` — Update product details
- `DELETE /api/products/{id}` — Delete a product

### Cart
- `POST /api/cart/add` — Add product to cart
- `GET /api/cart` — View cart items
- `DELETE /api/cart/remove/{itemId}` — Remove item from cart

### Order
- `POST /api/orders/place` — Place order
- `GET /api/orders/my-orders` — View user's order history

---

## Getting Started

### Clone the repo

```bash
git clone https://github.com/nikhilyadavsarajolu/ecommerce-backend.git
cd ecommerce-backend

##Set up MySQL Database

Create a database named ecommerce_db and update your credentials in application.properties.

##Properties

spring.datasource.username=your_mysql_username
spring.datasource.password=your_mysql_password

##Run the project

mvn spring-boot:run


---

##Sample JSON Payloads

##Register User

{
  "name": "Nikhil",
  "email": "nikhil@example.com",
  "password": "123456"
}

##Login User

{
  "email": "nikhil@example.com",
  "password": "123456"
}

##Add Product

{
  "name": "iPhone 15",
  "description": "Latest Apple iPhone",
  "price": 99999.0,
  "quantity": 5
}


---

## Author

**Sarajolu Nikhil Yadav**

[![LinkedIn](https://img.shields.io/badge/LinkedIn-Profile-blue?style=flat&logo=linkedin)](https://www.linkedin.com/in/nikhil-yadav-9a3a90270)
[![GitHub](https://img.shields.io/badge/GitHub-Profile-black?style=flat&logo=github)](https://github.com/nikhilyadavsarajolu)

---

License

This project is open-source and free to use.
    
