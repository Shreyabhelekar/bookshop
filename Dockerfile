# Use official OpenJDK 17 image
FROM openjdk:17-jdk-slim

# Set working directory
WORKDIR /app

# Copy the Spring Boot jar into the container
COPY target/bookshop-0.0.1-SNAPSHOT.jar app.jar

# Expose port (Render will override with $PORT)
EXPOSE 8081

# Dynamic port for Spring Boot
ENV PORT 8081

# Run the jar
ENTRYPOINT ["java","-jar","app.jar"]
