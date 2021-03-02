FROM openjdk:11

USER root
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} spring-reactive.jar
ENTRYPOINT ["java","-jar","/spring-reactive.jar"]
