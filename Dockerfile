FROM maven:3.8.6-amazoncorretto-17 AS MAVEN_BUILD
COPY ./ ./
RUN mvn clean package -DskipTests

FROM amazoncorretto:17
COPY --from=MAVEN_BUILD target/to-do-backend-0.0.1-SNAPSHOT.jar todo.jar
#EXPOSE ${PORT}
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "todo.jar"]