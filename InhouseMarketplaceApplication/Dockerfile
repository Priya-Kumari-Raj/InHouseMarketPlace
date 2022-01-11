FROM openjdk:8-jdk-alpine
EXPOSE 8082:8082
VOLUME /temp
RUN gradlew build/libs*.jar spring.jar
ENTRYPOINT ["java", "-jar", "spring.jar"]
