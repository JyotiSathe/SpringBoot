FROM jelastic/maven:3.9.5-openjdk-21  AS build
WORKDIR /
COPY src src
COPY pom.xml pom.xml
RUN mvn clean install -Dmaven.test.skip=true

FROM openjdk:21-jdk
LABEL "com.siemens.accountapi"="accountapi"
LABEL version=1.0-SNAPSHOT
COPY --from=build target/accountapipublisher-0.0.1-SNAPSHOT.jar accountapipublisher-0.0.1-SNAPSHOT.jar
EXPOSE 7072
ENTRYPOINT java -jar accountapipublisher-0.0.1-SNAPSHOT.jar