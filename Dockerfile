#docker pull eclipse-temurin:17.0.17_10-jdk-ubi9-minimal
FROM openjdk:17-ea-17-slim
WORKDIR /app
COPY ./target/visitor-mgmt-0.0.4-SNAPSHOT.jar /app
EXPOSE 8080
CMD ["java", "-jar", "visitor-mgmt-0.0.4-SNAPSHOT.jar", "--spring.profiles.active=dev","-Duser.timezone=Asia/Kolkata"]

### Docker compose for DB.
# services:
#   db:
#     image: postgres
#     restart: always
#     environment:
#       POSTGRES_PASSWORD: example
#     volumes:
#       - pgdata:/var/lib/postgresql/data
#
#   adminer:
#     image: adminer
#     restart: always
#     ports:
#       - 8080:8080
#
# volumes:
#   pgdata:
