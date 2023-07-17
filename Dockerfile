FROM eclipse-temurin:17

LABEL mentainer="vedha@gmail.com"

WORKDIR /app

COPY target/SpringBootStudentManagement-0.0.1-SNAPSHOT.jar /app/SpringBootStudentManagement.jar

ENTRYPOINT ["java", "-jar", "SpringBootStudentManagement.jar"]