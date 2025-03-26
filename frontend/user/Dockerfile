# Stage 1: Build frontend
FROM node:18-alpine AS builder
WORKDIR /app

# Copy package.json và cài đặt dependencies
COPY package.json package-lock.json ./
RUN npm install --legacy-peer-deps

# Copy toàn bộ project và build
COPY . .
RUN npm run build

# Stage 2: Serve với Nginx
FROM nginx:alpine
COPY --from=builder /app/dist /usr/share/nginx/html

# Expose cổng HTTP
EXPOSE 80

# Chạy Nginx
CMD ["nginx", "-g", "daemon off;"]
