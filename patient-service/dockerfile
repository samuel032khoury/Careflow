FROM maven:3.9.11-eclipse-temurin-21 AS builder

WORKDIR /app

COPY pom.xml .

RUN mvn dependency:go-offline -B

COPY src ./src

RUN mvn clean package

FROM eclipse-temurin:21-jdk AS runner

WORKDIR /app

ENV SPRING_DATASOURCE_URL=jdbc:postgresql://patient-service-db:5432/db
ENV SPRING_DATASOURCE_USERNAME=admin_user
ENV SPRING_JPA_HIBERNATE_DDL_AUTO=update
ENV SPRING_SQL_INIT_MODE=always

COPY --from=builder /app/target/patient-service-0.0.1-SNAPSHOT.jar ./patient-service.jar

EXPOSE 4000

ENTRYPOINT [ "java", "-jar", "patient-service.jar" ]

