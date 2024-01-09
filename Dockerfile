FROM openjdk:17-jre-slim
WORKDIR /app
COPY target/spring-graphql.jar .
EXPOSE 8080
ENTRYPOINT ["java","-jar","spring-graphql.jar"]