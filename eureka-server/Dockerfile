FROM openjdk:13-jdk-alpine

VOLUME /tmp

EXPOSE 8761

ARG JAR_FILE=target/eureka-server-0.0.1-SNAPSHOT.jar

ADD ${JAR_FILE} eureka-server-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/eureka-server-0.0.1-SNAPSHOT.jar"]

#Build Image
#docker build -t eureka-server .

#Run Image
#docker run --network="host" eureka-server