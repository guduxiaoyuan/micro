FROM java:8
VOLUME /tmp
ADD target/eureka-service-0.0.1-SNAPSHOT.jar micro-service/eureka-service.jar
ENTRYPOINT ["java","-Djava.securityegd=file:/dev/./urandom","-jar","/micro-service/eureka-service.jar","--spring.profiles.active=docker"]
