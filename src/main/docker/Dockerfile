FROM java:8
VOLUME /tmp
ADD ozi.jar ozi.jar
RUN sh -c 'touch /ozi.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/ozi.jar"]