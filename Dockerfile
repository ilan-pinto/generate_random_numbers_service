FROM openjdk:11.0.13-jre
COPY  target/random-0.0.1-SNAPSHOT.jar .  # maven should executed as part of the docker file creation. 

EXPOSE 8080

CMD ["/bin/bash", "-c", "java -jar ./random-0.0.1-SNAPSHOT.jar"]
