FROM openjdk:8
EXPOSE 8181
ADD target/champion-service.jar champion-service.jar
ENTRYPOINT ["java", "-jar", "/spring-boot-docker.jar.jar"]
