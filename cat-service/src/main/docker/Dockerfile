FROM java:8
VOLUME /tmp
ADD /root/.jenkins/workspace/SpringCloudDemo/cat-service/target/docker/cat-service-0.0.1-SNAPSHOT.jar micro-service/cat-service.jar
ENTRYPOINT ["java","-Djava.securityegd=file:/dev/./urandom","-jar","/micro-service/cat-service.jar"]
EXPOSE 8081
