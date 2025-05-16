# Stage 1: Build the app using Maven + Java
FROM maven:3.9.6-eclipse-temurin-21-alpine AS builder

WORKDIR /app

# Copy your pom.xml and source code to the container
COPY pom.xml .
COPY src ./src

# Build the application and skip tests for faster build (optional)
RUN mvn clean package -DskipTests

# Stage 2: Create the runtime image with only the JRE and your jar
FROM eclipse-temurin:21-jdk-alpine

WORKDIR /app

# Copy the jar built in the builder stage to this image
COPY --from=builder /app/target/*.jar app.jar

# Expose port 8080
EXPOSE 8080

# Run the jar
ENTRYPOINT ["java", "-jar", "app.jar"]
