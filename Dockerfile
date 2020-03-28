FROM openjdk:8
ADD build/libs/littlePigBot-0.0.1-SNAPSHOT.jar littlePigBot-0.0.1-SNAPSHOT.jar
EXPOSE 1488
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom", "-jar", "littlePigBot-0.0.1-SNAPSHOT.jar"]