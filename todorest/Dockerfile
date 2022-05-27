FROM eclipse-temurin:11-jre-alpine 
ADD target/todorest-0.0.1-SNAPSHOT.jar todorest.jar
EXPOSE 8081
ENTRYPOINT [ "java", "-jar" , "todorest.jar"]
