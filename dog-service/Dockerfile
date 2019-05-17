FROM java:8
VOLUME /tmp
ADD target/dog-service-0.0.1-SNAPSHOT.jar micro-service/dog-service.jar
ENTRYPOINT ["java","-Djava.securityegd=file:/dev/./urandom","-jar","/micro-service/dog-service.jar","--spring.profiles.active=docker"]
EXPOSE 8082