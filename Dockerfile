FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE=build/libs/sb-drone-demo-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} sb-drone-demo.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/sb-drone-demo.jar"]