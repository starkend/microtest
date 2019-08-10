# microtest

Microservices proof of concept

# Built with
- **Spring Boot**
- **Eureka Server**
- **Zuul Gateway Service**
- **Ribbon Client Side Load Balancer**
- **Feign HTTP Client**
- **Zipkin Distributed Tracing**
  - **Run Zipkin via Docker**
    - docker run -d -p 9411:9411 openzipkin/zipkin
- **RabbitMQ**
  - **Run RabbitMQ via Docker**
    - docker run -d -p 15672:15672 -p 5672:5672 rabbitmq:3-management