FROM jelastic/maven:3.9.5-openjdk-21  AS build
WORKDIR /
COPY src src
COPY pom.xml pom.xml
RUN mvn clean install -Dmaven.test.skip=true

FROM openjdk:21-jdk
LABEL "com.siemens.transactionapi"="transactionapi"
LABEL version=1.0-SNAPSHOT
COPY --from=build target/transactionapiconsumer-0.0.1-SNAPSHOT.jar transactionapiconsumer-0.0.1-SNAPSHOT.jar
EXPOSE 7074
ENTRYPOINT java -jar transactionapiconsumer-0.0.1-SNAPSHOT.jar