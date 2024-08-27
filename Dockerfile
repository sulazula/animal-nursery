FROM openjdk:21-jdk

WORKDIR /app

COPY out/artifacts/animal_nursery_jar/animal-nursery.jar /app/animal-nursery.jar

RUN mkdir -p /app/src/data

CMD ["java", "-jar", "animal-nursery.jar"]

VOLUME /app/data