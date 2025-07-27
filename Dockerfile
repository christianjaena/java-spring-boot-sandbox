FROM amazoncorretto:21

COPY target/*.jar /home/app/app.jar
WORKDIR /home/app
EXPOSE 8080
ENTRYPOINT java -jar /home/app/app.jar