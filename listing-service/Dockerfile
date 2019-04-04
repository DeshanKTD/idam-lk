FROM java:8-jdk-alpine

COPY ./target/listing-service-0.0.1-SNAPSHOT.jar /usr/app/

WORKDIR /usr/app

RUN sh -c 'touch listing-service-0.0.1-SNAPSHOT.jar'

ENTRYPOINT ["java","-jar","listing-service-0.0.1-SNAPSHOT.jar"]  
