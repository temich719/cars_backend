# Сборка
FROM gradle:8.14.3-jdk17 AS builder
WORKDIR /app
COPY . .
RUN gradle clean build -x test

# Запуск приложения
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=builder /app/build/libs/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
