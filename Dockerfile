FROM openjdk:19-jdk-alpine3.16

WORKDIR /usr/app

COPY /var/jenkins_home/workspace/docker-jenkins-freestyle/target/my-app-1.0-SNAPSHOT.jar .

EXPOSE 8080

ENTRYPOINT ["java","-jar","my-app-1.0-SNAPSHOT.jar"]

