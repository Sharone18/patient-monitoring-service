# Use the official OpenJDK 17 base image
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file from your host into the container
# Replace 'your-app.jar' with the name of your JAR file

RUN mkdir -p src/main/resources/static
COPY src/main/resources/static/mock_data_ecg.csv src/main/resources/static
COPY target/*.jar app.jar
EXPOSE 8080
# Expose any ports your application needs (optional)
# EXPOSE 8080

# Command to run the JAR file
CMD ["java", "-jar", "app.jar"]
