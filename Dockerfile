# 使用官方的 OpenJDK 作为基础镜像
FROM openjdk:8-jdk-alpine

# 将 JAR 文件复制到容器中
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE}  /usr/app/wrk.jar

# 进入工作目录
WORKDIR /usr/app

# 运行 Spring Boot 应用
ENTRYPOINT ["java", "-jar", "wrk.jar"]

# 暴露应用端口
EXPOSE 8080

