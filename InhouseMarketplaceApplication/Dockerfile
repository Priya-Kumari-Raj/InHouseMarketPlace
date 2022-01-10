FROM openjdk: 8-jdk-alpine
EXPOSE 8080:8080
VOLUME /temp
RUN radlew build/libs*.jar spring.jar
ENTERYPOINT ["java", "-jar", "spring.jar"]