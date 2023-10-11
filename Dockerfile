FROM openjdk:19
VOLUME /tmp
COPY target/*.jar demo-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/demo-0.0.1-SNAPSHOT.jar"]
EXPOSE 8080