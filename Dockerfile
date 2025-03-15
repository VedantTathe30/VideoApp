# Build stage
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests
RUN ls -l target/  # Debugging step to check if the JAR is created

# Run stage
FROM openjdk:17.0.1-jdk-slim
WORKDIR /app
COPY --from=build /app/target/VideoApp-0.0.1-SNAPSHOT.jar app.jar  # Copy the correct JAR

EXPOSE 9191
ENTRYPOINT ["java", "-jar", "app.jar"]
