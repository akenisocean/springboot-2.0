### actuator实现优雅关闭项目
1. 配置
```yaml
management:
# 开启关闭项目端口
    shutdown:
      enabled: true
```
2. POST请求调用
```shell script
curl -X POST http://{hostname|ip}:{server.port}/actuator/shutdown
```

## 通过注解@Endpoint方式来暴露指定端点

```java

@Component
@Endpoint(id = "redisHealthEndpoint")
public class RedisHealthEndpoint {

    @ReadOperation
    public Map<String, Object> endpoint() {
        Map<String, Object> map = new HashMap<>(16);
        map.put("message", "this is my endpoint");
        return map;
    }
 

}

```

请求地址：GET http://{ip地址}:{端口号}/actuator/redisHealthEndpoint

此时返回数据及时map中设置的参数

```json
{
  "message": "this is my endpoint"
}
```