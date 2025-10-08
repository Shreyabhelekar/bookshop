# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim

# Set working directory
WORKDIR /app

# Copy the jar file into the container
COPY target/bookshop-0.0.1-SNAPSHOT.jar app.jar

# Expose port (Render will override with $PORT)
EXPOSE 8081

# Set dynamic port for Spring Boot
ENV PORT 8081

# Run the jar file
ENTRYPOINT ["java","-jar","app.jar"]
