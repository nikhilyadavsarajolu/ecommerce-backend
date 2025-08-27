# 🛒 E-Commerce Backend

A Spring Boot REST API backend for an **E-Commerce Application**, providing secure authentication, product management, cart, and order handling.  

---

## 🚀 Features
- User **Registration & Login** with JWT authentication  
- Role-based access (Admin / User)  
- Product Management (CRUD APIs)  
- Cart Management  
- Order Placement & Retrieval  
- Input Validations & Exception Handling  

---

## 🛠️ Tech Stack
- **Java 17**
- **Spring Boot 3**
- **Spring Security (JWT Authentication)**
- **MySQL Database**
- **Hibernate / JPA**
- **Maven**

---

##  📂 Project Setup

1️⃣ Clone the repository
```bash
git clone https://github.com/nikhilyadavsarajolu/ecommerce-backend.git

cd ecommerce-backend
```
2️⃣ Configure Database

Update your application.properties with MySQL credentials:
```bash
spring.datasource.url=jdbc:mysql://localhost:3306/ecommerce_db
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```
3️⃣ Run the project
```bash
mvn spring-boot:run
```
---
## 📌 API Endpoints
🔐 Authentication

- POST /api/auth/register → Register new user

- POST /api/auth/login → Login & get JWT token

🛍️ Products

- POST /api/products/add → Add product (Admin only)

- GET /api/products → List all products

- GET /api/products/{id} → Get product by ID

- PUT /api/products/{id} → Update product

- DELETE /api/products/{id} → Delete product

🛒 Cart

- POST /api/cart/add → Add item to cart

- GET /api/cart → View cart

📦 Orders

- POST /api/orders/place → Place order

- GET /api/orders → Get user orders

---
## ✅ Future Improvements
- Payment gateway integration

- Inventory tracking

- Product categories & reviews
## 🤝 Contributing
Pull requests are welcome!

---
## 👨‍💻 Author
Sarajolu Nikhil Yadav 
 
[LinkedIn](https://www.linkedin.com/in/nikhil-yadav-9a3a90270) | [GitHub](https://github.com/nikhilyadavsarajolu)
