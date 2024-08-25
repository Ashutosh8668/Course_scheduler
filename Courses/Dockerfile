# Use an official OpenJDK 21 runtime as a parent image
FROM openjdk:24-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the jar file from the target directory into the container
COPY target/Courses-0.0.1-SNAPSHOT.jar /app/app.jar

# Expose port 8080 to the outside world
EXPOSE 8080

# Define the command to run the application
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
