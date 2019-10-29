通过注解@Endpoint方式来暴露指定端点

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