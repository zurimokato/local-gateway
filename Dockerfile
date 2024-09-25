FROM ubuntu:latest
LABEL authors="noj23"
FROM openjdk:17-jdk-slim
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} spring-gateway.jar
ENTRYPOINT ["java", "-jar","/spring-gateway.jar"]