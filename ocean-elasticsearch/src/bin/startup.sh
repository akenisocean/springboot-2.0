# 可以通过docker容器中的-e命令覆盖当前参数,添加默认可以使用如下参数`:=添加的参数`
export JAVA_OPTS=${JAVA_OPTS}
export TARGET_JAR=${TARGET_JAR}

# 如何没设置，添加一个默认
if [ -z "$JAVA_OPTS" ]; then
  JAVA_OPTS="-server -Xms1024m -Xmx1024m -Xss512k -XX:MetaspaceSize=512m -XX:MaxMetaspaceSize=1024m"
fi

export JAVA_OPTS="${JAVA_OPTS} -Djava.security.egd=file:/dev/./urandom -Dfile.encoding=UTF-8"


# 启动当前服务
exec java -jar $JAVA_OPTS $TARGET_JAR