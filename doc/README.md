# 模块介绍
## druid-mybatis-multiple
```text
mybatis+druid+mysql通过分包配置的方式实现多数据源的实现。
http://{ip}:{server.port}/druid/index.html
```
## multiThreadTest

```text
多线程测试模块。
```

## ocean-config-server

SpringCloudConfig配置中心，统一管理springcloud模块中的配置。
```text
实现了git远程管理配置和本地文件两种方式实现配置的统一管理。
```

## ocean-data-structure
数据结构统一测试和学习模块。

## ocean-demo
实现内容：
- 集成了携程apollo统一配置管理中心
- springboot异步线程配置以及线程上下文拷贝配置
- springmvc拦截器配置
- springboot统一异常处理
- 自定义springboot-actuator健康检查
```text



#  apollo配置中心集成
1. 添加注解@EnableApolloConfig
    @Value("${smart:200}")
        private String smart;

	@GetMapping("/smart")
	public String smart() {
		return String.format("系统(%s)欢迎您访问！", smart);
	}


#apollo.meta=http://49.235.205.24:8080
app.id=haha
apollo.bootstrap.enabled = true
apollo.bootstrap.namespaces = application.yml
apollo.bootstrap.eagerLoad.enabled=true
```



## ocean-ldap
springboot集成LDAP（Lightweight Directory Access protocol）

## oecan-eureka
springcloud组件eureka的分布式注册中心实现

## ocean-feign-consumer 和ocean-feign-provider和ocean-feign-provider2
springcloud组件feign的实现

## ocean-gateway
springcloud2.0后的网管组件springgateway

## ocean-hystrix-consumer和ocean-hystirx-consumer2和ocean-hystrix-provider
springcloud组件histrix实现容错限流

## ocean-mail
springboot实现邮箱发送

## ocean-netty
springboot集成netty测试

## ocean-pay-demo
springboot实现支付测试

## ocean-rabbit-producer和ocean-rabbitmq-consumer
springcloud集成rabbitmq消息队列实现发布订阅等操作

## ocean-security
springcloud组件springsecurity实现统一认证和授权

##websockettest
websocket测试
