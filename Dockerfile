FROM openjdk:18-ea-11-jdk-alpine
# 非rootユーザーで実行
RUN addgroup -S spring-group && adduser -S spring-user -G spring-group
USER spring-user:spring-group
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]