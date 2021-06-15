FROM openjdk:11
EXPOSE 8181
ADD target/champion-service.jar champion-service.jar
ENTRYPOINT ["java", "-jar", "/champion-service.jar"]
