FROM openjdk:17-ea-11-jdk-slim
COPY ./build/libs/*SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]