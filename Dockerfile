# Use the official OpenJDK 17 base image
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

RUN mkdir -p src/main/resources/static
COPY src/main/resources/static/mock_data_ecg.csv src/main/resources/static
COPY target/*.jar app.jar
EXPOSE 8080

# Command to run the JAR file
CMD ["java", "-jar", "app.jar"]
