FROM maven:3.8.3-openjdk-17 AS build 


COPY src /app/src                                                 
COPY pom.xml /app                                           
RUN mvn -f /app/pom.xml clean package install -DskipTests

FROM openjdk:17.0.1-jdk-slim                              


COPY --from=build app/target/workshop.githubactions.jar /app-service/workshop.githubactions.jar   
WORKDIR /app-service

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "workshop.githubactions.jar"]