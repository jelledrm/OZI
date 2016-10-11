FROM java:8
VOLUME /tmp
ADD OZI.jar OZI.jar
RUN sh -c 'touch /OZI.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/OZI.jar"]