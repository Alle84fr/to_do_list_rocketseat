FROM ubuntu:latest AS build

RUN apt-get update
RUN apt-get install openjdk-17-jdk -y

FROM openjdk:24-jdk-slim
COPY . .

RUN apt-get clean && \
    rm -rf /var/lib/apt/lists/* && \
    apt-get update && \
    apt-get install -y maven
RUN mvn clean install

EXPOSE 8080

COPY --from=build /target/to_do_list_1.0.0.jar app.jar

ENTRYPOINT [ "java", "-jar", "app.jar" ]
