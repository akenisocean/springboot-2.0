FROM openjdk:8-jdk-alpine
MAINTAINER chao <jichao@jingkunsystem.com>

# 设置环境变量
ENV LANG=C.UTF-8 LC_ALL=C.UTF-8 \
    TINI_VERSION=v0.19.0 \
    TINI_SHA=c5b0666b4cb676901f90dfcb37106783c5fe2077b04590973b885950611b30ee \
    TARGET_JAR=ocean-elasticsearch-1.0.0.jar \
    BASE_DIR=/app/data/ \
    BASE_SHELL=startup.sh

# 创建app-data目录
RUN mkdir -p $BASE_DIR

# 拷贝需要的内容
COPY ./target/${TARGET_JAR} $BASE_DIR
COPY ./bin/${BASE_SHELL} $BASE_DIR
COPY --from=hengyunabc/arthas:latest /opt/arthas /opt/arthas
# 设置工作目录
WORKDIR $BASE_DIR

# 添加需要的依赖
RUN echo "http://mirrors.aliyun.com/alpine/v3.9/main" > /etc/apk/repositories \
    && echo "http://mirrors.aliyun.com/alpine/v3.9/community" >> /etc/apk/repositories \
    && apk update upgrade \
    && apk add --no-cache procps unzip curl bash tzdata busybox-extras vim wget \
    && ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime \
    && echo "Asia/Shanghai" > /etc/timezone \
    && curl -fsSL https://github.com/krallin/tini/releases/download/${TINI_VERSION}/tini-static-amd64 -o /bin/tini \
    && chmod +x /bin/tini \
     && echo "$TINI_SHA  /bin/tini" | sha256sum -c - && sh -c "touch ${TARGET_JAR}" && chmod +x ${BASE_SHELL}


# 暴露端口
EXPOSE 10000

# 暴露挂载卷
VOLUME ["/app/data/"]

# 通过/bin/tini解决优雅关闭容器，类似于kill -15
ENTRYPOINT ["/bin/tini", "--","/app/data/startup.sh"]


