# Use OpenJDK 17 base image
FROM openjdk:17-jdk-alpine

# Set working directory
WORKDIR /app

# Copy the Spring Boot jar
COPY target/*.jar app.jar

# Expose the port your app runs on
EXPOSE 8881

# Run the application
ENTRYPOINT ["java","-jar","app.jar"]
