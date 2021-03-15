FROM openjdk:8u111-jdk-alpine
EXPOSE 8123
ADD target/app.jar /app.jar
ENTRYPOINT ["java","-jar","/app.jar"]