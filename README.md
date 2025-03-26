# EventBox - Microservices Project

EventBox là một hệ thống quản lý sự kiện sử dụng kiến trúc microservices, bao gồm các dịch vụ xác thực, sự kiện, blog, cổng API và hai giao diện người dùng riêng biệt (User & Admin).

## 🛠 Công nghệ sử dụng
- **Backend:** Spring Boot, MySQL, MongoDB, JWT Authen
- **Frontend:** Vue.js
- **Gateway:** Spring Cloud Gateway
- **Containerization:** Docker, Docker Compose

## 📂 Cấu trúc dự án

```
EventBox/
|-- backend/
|   |-- AuthenService/
|   |-- BlogService/
|   |-- EventService/
|   |-- gateway/
|-- frontend/
|   |-- user/
|   |-- company/
|-- docker-compose.yml
|-- README.md
```

## 🚀 Hướng dẫn cài đặt và chạy dự án

### 1. Yêu cầu hệ thống

- **Docker** và **Docker Compose** được cài đặt trên máy.
- **Node.js** (nếu muốn chạy frontend ngoài Docker).

### 2. Cách chạy dự án

 - Chạy toàn bộ hệ thống với Docker Compose:

docker-compose up -d --build

- Chạy riêng frontend user & admin:

docker-compose up -d --build frontend-user frontend-admin

- Dừng toàn bộ container:

docker-compose down

## 🏗 Cấu hình dịch vụ

### 1. Cơ sở dữ liệu

- **MySQL** chạy trên cổng `3306`, database: `eventbox`
- **MongoDB** chạy trên cổng `27017`, chứa `auth_db` và `blog_db`

### 2. Cổng API

- **Auth Service**: `8081`
- **Event Service**: `8082`
- **Blog Service**: `8083`
- **Gateway**: `8080`

### 3. Frontend

- **User Frontend**: `http://localhost:3001`
- **Admin Frontend**: `http://localhost:3002`

## 📌 Môi trường biến

- Cấu hình các biến môi trường trong `docker-compose.yml`:

SPRING_DATASOURCE_URL: jdbc:mysql://mysql-db:3306/eventbox
SPRING_DATASOURCE_USERNAME: root
SPRING_DATASOURCE_PASSWORD: root
SPRING_DATA_MONGODB_URI: mongodb://mongo-db:27017/auth_db



