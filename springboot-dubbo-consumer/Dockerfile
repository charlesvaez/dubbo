#基于哪个镜像
FROM java:8
#指定维护者信息
MAINTAINER hcx
#将本地文件夹挂载到当前容器
VOLUME /tmp
#复制文件到容器
ADD target/springboot-dubbo-consumer.jar app.jar
RUN sh -c 'touch /app.jar'
ENV JAVA_OPTS=""
EXPOSE 9098
#配置容器启动后执行的命令
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
