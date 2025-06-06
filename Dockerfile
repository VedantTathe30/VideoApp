# Build stage
FROM maven:3.8.5-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests
RUN ls -l target/  # This will show the contents of the target directory

# Run stage
FROM openjdk:17.0.1-jdk-slim
COPY --from=build target/VideoApp-0.0.1-SNAPSHOT.jar VideoApp.jar
EXPOSE 9191
ENTRYPOINT ["java", "-jar", "VideoApp.jar"]
