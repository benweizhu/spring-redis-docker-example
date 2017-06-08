FROM java:8
VOLUME /tmp
ADD build/libs/spring-redis-docker-example.jar spring-redis-docker-example.jar
RUN bash -c 'touch /spring-redis-docker-example.jar'
EXPOSE 8080
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/spring-redis-docker-example.jar"]
