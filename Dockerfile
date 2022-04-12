FROM openjdk:11
ADD target/buscar-0.0.1-SNAPSHOT.jar app2.jar
RUN sh -c 'touch /.jar'
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "/app2.jar"]