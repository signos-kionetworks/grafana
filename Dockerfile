FROM tomcat:9.0.58-jdk8

RUN apt-get update && apt-get install -y iputils-ping && apt-get install -y telnet && apt-get install -y vim

COPY grafana-web/target/grafana.war /usr/local/tomcat/webapps/                
