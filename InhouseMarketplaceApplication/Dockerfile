FROM openjdk:8-jdk-alpine
VOLUME /temp
EXPOSE 8082
ADD build/libs/springbootpostgresqldocker-0.0.1-SNAPSHOT.jar springbootpostgresqldocker.jar
ENTRYPOINT ["java","-jar","/springbootpostgresqldocker.jar"]
