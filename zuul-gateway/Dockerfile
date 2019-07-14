FROM openjdk:13-jdk-alpine

VOLUME /tmp

EXPOSE 9999

ARG JAR_FILE=target/zuul-gateway-0.0.1-SNAPSHOT.jar

ADD ${JAR_FILE} zuul-gateway-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/zuul-gateway-0.0.1-SNAPSHOT.jar"]

#Build Image
#docker build -t zuul-gateway .

#Run Image
#docker run --network="host" zuul-gateway