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
ADD /ocean-gateway-${VERSION}.jar ocean-gateway-${VERSION}.jar
#RUN bash -c 'touch /app.jar'
# 暴露对外端口号
EXPOSE 18000
# 执行命令
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/ocean-gateway-${VERSION}.jar"]