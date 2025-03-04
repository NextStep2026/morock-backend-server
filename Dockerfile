FROM openjdk:17-jdk
COPY build/libs/*SNAPSHOT.jar app.jar

EXPOSE 8080

LABEL authors="c"

ENTRYPOINT ["java", "-jar", "/app.jar"]