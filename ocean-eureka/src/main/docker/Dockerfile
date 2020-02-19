FROM openjdk:8-jdk-alpine
MAINTAINER dachao <jc164214878@163.com>
#　设置版本号
ENV VERSION 1.0.0
RUN echo "http://mirrors.aliyun.com/alpine/v3.8/main" > /etc/apk/repositories \
    && echo "http://mirrors.aliyun.com/alpine/v3.8/community" >> /etc/apk/repositories \
    && apk update upgrade \
    && apk add --no-cache procps unzip curl bash tzdata \
    && ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime \
    && echo "Asia/Shanghai" > /etc/timezone
#    设置工作目录
VOLUME /tmp
#  将打包的jar包放入到/tmp中并成为app.jar

ADD ocean-eureka-${VERSION}.jar app.jar
#RUN bash -c 'touch /app.jar'
# 暴露对外端口号
EXPOSE 8761
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]