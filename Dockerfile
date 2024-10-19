FROM openjdk:17-jdk-slim
LABEL authors="noj23"
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} spring-gateway.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar","/spring-gateway.jar"]