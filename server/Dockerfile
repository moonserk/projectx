FROM adoptopenjdk:11-jdk-hotspot
VOLUME /main-app
ADD . .
EXPOSE 8080
ENTRYPOINT ["./mvnw", "spring-boot:run"]