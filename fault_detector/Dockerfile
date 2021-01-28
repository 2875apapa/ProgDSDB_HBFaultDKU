
FROM maven:3-jdk-8 as builder
WORKDIR /project
COPY fault_detector .
RUN mvn package

FROM java:8-alpine
WORKDIR /app
COPY --from=builder /project/target/fault_detector-0.0.1-SNAPSHOT.jar ./fault_detector.jar
CMD java -jar fault_detector.jar