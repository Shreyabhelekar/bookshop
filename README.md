# 📚 BookShop Web Application

BookShop is a full-stack web application built with **Spring Boot (Java)** for the backend and **HTML/CSS/Bootstrap/JavaScript** for the frontend. It allows users to register, login, browse books, add them to a cart, and place orders. Admin users can manage the book inventory.

---

## 🚀 Features

### 👤 User Features
- Sign up / Login (handled via localStorage session in frontend)
- View available books
- Add books to cart
- View and remove books from cart
- Place orders

### 🛠 Admin Features
- Login as admin
- Add new books
- View and delete books
- View all orders placed

---

## 🧱 Tech Stack

| Layer       | Technology                     |
|-------------|--------------------------------|
| Backend     | Spring Boot (Java)             |
| Database    | MySQL                          |
| Frontend    | HTML, CSS, Bootstrap, JavaScript |
| REST APIs   | Spring Web                     |
| ORM         | Spring Data JPA (Hibernate)    |

---

## 🗂️ Project Structure
bookshop/

├── src/

│ ├── main/

│ │ ├── java/com/bookshop/...

│ │ └── resources/

│ │ ├── static/

│ │ ├── templates/

│ │ └── application.properties

│ └── test/

├── pom.xml

└── README.md


---

## 🔑 Roles

- **User** – Can register, browse books, add to cart, and order.
- **Admin** – Can manage books and view orders.

Role-based UI is handled using localStorage (no Spring Security).

---

## ⚙️ Setup Instructions

### 1. Clone the Repository

```bash
git clone https://github.com/Shreyabhelekar/bookshop.git
cd bookshop
```

## Configure Database
In application.properties, update your MySQL credentials:
```bash
spring.datasource.url=jdbc:mysql://localhost:3306/book_db
spring.datasource.username=root
spring.datasource.password=your_mysql_password
```
### Then create the database:
```bash
CREATE DATABASE book_db;
```

## Run the Backend
You can run it using:

- IDE: Run BookshopApplication.java

- CLI: mvn spring-boot:run

## Open Frontend
Navigate to /src/main/resources/static and open index.html in the browser.

## License
This project is open-source and free to use under the MIT License.

## Author
Shreya Bhelekar
gmail : shreyabhelekar20@gmail.com

LinkedIn : www.linkedin.com/in/shreya-bhelekar-ab315a268

