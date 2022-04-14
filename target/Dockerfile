FROM openjdk
VOLUME /tmp
ARG JAR_FILE=*.jar
COPY ${JAR_FILE} frodo-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/frodo-0.0.1-SNAPSHOT.jar"]