FROM maven:3.5-jdk-8
#MAINTAINER open-data-tu
ADD . /code

WORKDIR /code

RUN mvn clean install

# Dependencies
ADD target/gs-batch-processing-0.1.0.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
