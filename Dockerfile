# Stage 1: Build the application using Maven
FROM maven:3.9.6-eclipse-temurin-21 AS build
COPY . .
RUN mvn clean package -DskipTests

# Stage 2: Create a slim image to run the application
FROM openjdk:17.0.1-jdk-slim
COPY --from=build /target/carTask-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]