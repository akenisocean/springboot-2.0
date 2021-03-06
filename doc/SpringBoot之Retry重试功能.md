# 前言

## 应用场景





## SpringBoot快速上手

1. 添加对应的依赖
```xml
<!-- 重试机制 -->
<dependency>
    <groupId>org.springframework.retry</groupId>
    <artifactId>spring-retry</artifactId>
    <version>1.2.4.RELEASE</version>
</dependency>
<dependency>
    <groupId>org.aspectj</groupId>
    <artifactId>aspectjweaver</artifactId>
    <version>1.9.4</version>
</dependency>
```
2. 添加注解
```java
@EnableRetry
```
3. 编写测试
使用注解@Retryable和@Recover
```text
@Retryable注解:
value: 抛出指定异常才会重试
include：和value一样，默认为空，当exclude也为空时，默认所以异常
exclude：指定不处理的异常
maxAttempts：最大重试次数，默认3次
backoff：重试等待策略，默认使用@Backoff，@Backoff的value默认为1000L；multiplier（指定延迟倍数）


@Recover注解：
当重试达到指定次数时候该注解的方法将被回调
发生的异常类型需要和@Recover注解的参数一致
@Retryable注解的方法不能有返回值，不然@Recover注解的方法无效
```

```java

@Service
public class RetryService {
  private Logger logger = LoggerFactory.getLogger(RetryService.class);
  @Retryable(value = Exception.class, maxAttempts = 3, backoff = @Backoff(delay = 2000L, multiplier = 2))
  public void devide(double a, double b){
      logger.info("开始进行除法运算");
      if (b == 0) {
          throw new RuntimeException();
      }
      logger.info("{} / {} = {}", a, b, a / b);
  }
  @Recover
  public void recover() {
      logger.error("被除数不能为0");
  }

}
```

