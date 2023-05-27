ARG BUILD_IMAGE=maven:3.8.3
ARG RUNTIME_IMAGE=adoptopenjdk:11-jre-hotspot

FROM ${BUILD_IMAGE} as dependencies
COPY pom.xml ./

FROM dependencies as build
COPY src ./src
RUN mvn clean package

FROM ${RUNTIME_IMAGE}
EXPOSE 8070
ARG JAR_FILE=target/carservice_kafka-0.0.1-SNAPSHOT.jar
COPY --from=build ${JAR_FILE} app.jar

CMD java -jar app.jar
