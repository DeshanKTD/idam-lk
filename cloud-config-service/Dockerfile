FROM java:8-jdk-alpine

COPY ./target/cloud-config-service-0.0.1-SNAPSHOT.jar /usr/app/

WORKDIR /usr/app

RUN sh -c 'touch cloud-config-service-0.0.1-SNAPSHOT.jar'

ENTRYPOINT ["java","-jar","cloud-config-service-0.0.1-SNAPSHOT.jar"]  
