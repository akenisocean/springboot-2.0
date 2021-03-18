# 服务说明
通过springboot admin实现对微服务之间的监控操作


# 操作
1. 启动服务，并通过浏览器查看当前的管理界面
```$xslt
http://localhost:10000/ocean-admin
```

2. 如果发现其他服务，可以通过nacos的统一注册来实现，只需要在其他服务注册到nacos中添加如下的metadata信息即可，后续
springboot-admin会到nacos的注册中心去取对应的服务地址信息，并进行监控

样例如下： 
```$xslt
# 服务名称
spring:
  cloud:
    nacos:
      # nacos地址
      server-addr: 192.168.3.239:8848
      username: jkstack
      password: 123qweASD
      # 注册中心配置
      discovery:
        # 命名空间，用来区分环境
        namespace: di-deploy-dev
        # 设置管理上报地址，后续springboot-admin监控来判断
        metadata:
          management:
            context-path: ${server.servlet.context-path}/actuator
      # 配置中心配置
      config:
        # 后缀
        file-extension: yaml
        # 组名
        group: DEV_GROUP
        # 命名空间，用来区分环境
        namespace: di-deploy-dev
```