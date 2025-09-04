# Use OpenJDK 17
FROM openjdk:17-jdk-alpine

# Set working directory
WORKDIR /app

# Copy built JAR into container
COPY target/*.jar app.jar

# Expose port
EXPOSE 8881

# Optional: add wait-for-it to handle DB startup
ADD https://raw.githubusercontent.com/vishnubob/wait-for-it/master/wait-for-it.sh /wait-for-it.sh
RUN chmod +x /wait-for-it.sh

# Run app, waiting for MySQL
CMD ["/wait-for-it.sh", "db:3306", "--timeout=30", "--", "java", "-jar", "app.jar"]
