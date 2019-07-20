FROM openjdk:13-jdk-alpine

VOLUME /tmp

EXPOSE 5555

ARG JAR_FILE=target/currency-service-loadbalancer-0.0.1-SNAPSHOT.jar

ADD ${JAR_FILE} currency-service-loadbalancer-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/currency-service-loadbalancer-0.0.1-SNAPSHOT.jar"]

#Build Image
#docker build -t currency-service-loadbalancer .

#Run Image
#docker run --network="host" currency-service-loadbalancer