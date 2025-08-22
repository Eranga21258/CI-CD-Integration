FROM openjdk:17-jdk-alpine

WORKDIR /app

ADD target/devops-integration.jar devops-integration.jar

EXPOSE 8881

ENTRYPOINT ["java","-jar","devops-integration.jar"]
