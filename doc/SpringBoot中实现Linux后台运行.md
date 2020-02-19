# SpringBoot中实现linux后台运行

参考文档：https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#deployment-install

## 通过init.d服务来实现
1. 将springboot插件添加可执行设置 <executable>true</executable>
```xml
<plugin>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-maven-plugin</artifactId>
    <configuration>
        <executable>true</executable>
    </configuration>
</plugin>
```
2. 打成jar包
```shell script
mvn clean package -Dmaven.test.skip-=true
```
3. 放到linux服务器(服务器先配好java环境),并通过init.d服务安装

该init.d脚本支持如下功能：
- 以拥有jar文件的用户身份启动服务
- 使用/var/run/<appname>/<appname>.pid跟踪应用程序的PID
- 


3.1 创建硬连接
比如上传的文件名为ocean-demo-1.0.jar  路径为/usr/local/ocean-demo-1.0.jar
命令如下：
```shell script
sudo ln -s /app/ocean-demo-1.0.jar /etc/init.d//ocean-demo-1.0.jar
# 给添加的硬连接执行全新啊
chmod a+x /etc/init.d/ocean-demo-1.0
```

3.2 三种操作命令：start stop restart
```shell script
/etc/init.d/ocean-demo-1.0 start
```


## 通过systemctl命令管理
1. 进入`/etc/systemd/system`目录下创建一个以.service结尾的文件
```text
vim oceanDemoStart.service

[Unit]
Description=ocean-demo-1.0
After=syslog.target

[Service]
User=root
ExecStart=/usr/local/jdk1.8.0_141/bin/java -Dsun.misc.URLClassPath.disableJarChecking=true -jar /usr/local/ocean-demo-1.0.jar
SuccessExitStatus=143

[Install]
WantedBy=multi-user.target
```

2. 通过如下五个命令实现具体操作： start|restart|stop|enable|disable
```shell script
systemctl start oceanDemoStart.service
systemctl restart oceanDemoStart.service
systemctl stop oceanDemoStart.service
...
```