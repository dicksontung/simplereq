FROM maven:3-openjdk-11

COPY src src
COPY pom.xml pom.xml
RUN mvn clean package

CMD ["java", "-jar", "target/app.jar"]