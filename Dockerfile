FROM openjdk:8
ADD target/FluentConnect-0.0.1-SNAPSHOT-jar-with-dependencies.jar FluentConnect-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","FluentConnect-0.0.1-SNAPSHOT.jar"]