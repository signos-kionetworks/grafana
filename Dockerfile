FROM alpine/git as clone
WORKDIR /app
RUN git clone https://jgalindol-kionetworks-com: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@github.com/signos-kionetworks/grafana.git

FROM maven:3.5-jdk-8-alpine as build
WORKDIR /app
COPY --from=clone /app/grafana /app 
RUN mvn clean install -DskipTests 

FROM tomcat:9.0.58-jdk8
RUN apt-get update && apt-get install -y iputils-ping && apt-get install -y telnet
COPY --from=build /app/grafana-web/target/grafana.war /usr/local/tomcat/webapps/

