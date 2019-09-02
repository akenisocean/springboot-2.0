# 路由配置的坑

1. 添加Routes路由规则时,每一个id都必须匹配一个Path,否则会抛出下标不存在异常

```yaml
spring:
  cloud:
    gateway:
      routes:
        - id: after_route
          uri: http://127.0.0.1:9000
          predicates:
            - Path=/foo/{segment},/bar/{segment}
#   id 中不许存在断言对应的path
        - id: default_path
          uri: http://127.0.0.1:9000
          predicates:
            - Path=/**
          
```