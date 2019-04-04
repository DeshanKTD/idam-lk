FROM java:8-jdk-alpine

COPY ./target/eureka-registry-service-0.0.1-SNAPSHOT.jar /usr/app/

WORKDIR /usr/app

RUN sh -c 'touch eureka-registry-service-0.0.1-SNAPSHOT.jar'

ENTRYPOINT ["java","-jar","eureka-registry-service-0.0.1-SNAPSHOT.jar"]  
