FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/flight-reservation.jar /app/flight-reservation-service.jar

EXPOSE 8081

ENV JAVA_OPTS=""

ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar /app/flight-reservation.jar"]

