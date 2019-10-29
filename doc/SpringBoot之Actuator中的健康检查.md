# 健康检查必要性说明
```text
一般我们在进行项目开发时都会一些中间件（例如：Redis、RabbitMQ、Mysql等）,但是一旦出现例如网络抖动等原因导致客户端连接中间件失效
而客户端无法检测报警，导致用户在访问该客户端项目时报错，但是工作人员因为没有这方面检测，导致用户在可能涉及到这些中间件的接口失败。
此时就需要一个健康检查工具，检查这些中间件是否能够使用。例如通过使用一些监控工具（例如prometheus）定期拉取这些健康报告，如有问题
通知指定的调度人员即可。

```

# 实现方式

导入依赖的jar包
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
```

继承抽象类AbstractHealthIndicator.doHealthCheck()方法

```java
@Component
//配置文件中包含myredis配置则该健康检查生效
//@ConditionalOnEnabledHealthIndicator("myredis")
public class MyRedisHealthIndicator extends AbstractHealthIndicator {

    static final String VERSION = "version";

    static final String REDIS_VERSION = "redis_version";

    private final RedisConnectionFactory redisConnectionFactory;

    public MyLajiRedisHealthIndicator(RedisConnectionFactory connectionFactory) {
        super("Redis health check failed");
        Assert.notNull(connectionFactory, "ConnectionFactory must not be null");
        this.redisConnectionFactory = connectionFactory;
    }

    @Override
    protected void doHealthCheck(Health.Builder builder) {
        RedisConnection connection = RedisConnectionUtils
                .getConnection(this.redisConnectionFactory);
        try {
            if (connection instanceof RedisClusterConnection) {
                ClusterInfo clusterInfo = ((RedisClusterConnection) connection)
                        .clusterGetClusterInfo();
                builder.up().withDetail("cluster_size", clusterInfo.getClusterSize())
                        .withDetail("slots_up", clusterInfo.getSlotsOk())
                        .withDetail("slots_fail", clusterInfo.getSlotsFail());
            }
            else {
                Properties info = connection.info();
                builder.up().withDetail(VERSION, info.getProperty(REDIS_VERSION));
            }
        }
        finally {
            RedisConnectionUtils.releaseConnection(connection,
                    this.redisConnectionFactory);
        }
    }
}

```

而后配置暴露端口 application.yml

```yaml
# 暴露所有的web端口
management:
  endpoints:
    web:
      exposure:
        include: '*'
# always代表所有的健康检查都可以看到        
  endpoint:
    health:
      show-details: always
```
全部健康检查地址： GET http://{ip地址}:{端口号}/actuator/health  
指定请求地址： GET http://{ip地址}:{端口号}/actuator/health/myRedisHealth

```text
备注: 默认情况下使用@Bean名称的前部分作为{component},而后去掉HealthIndicator字符。
即名称为：MyRedisHealthIndicator = 请求访问 myRedis
```

