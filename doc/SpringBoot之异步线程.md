# SpringBoot内部封装了异步线程调用，我们只需要简单配置即可使用


**配置**
```java
@Configuration
public class AsyncThreadConfig {

    public static final String ASYNC_EXECUTOR_NAME = "asyncExecutor";

    @Bean(name=ASYNC_EXECUTOR_NAME)
    public Executor asyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        // for passing in request scope context
        executor.setTaskDecorator(new ContextCopyingDecorator());
        executor.setCorePoolSize(3);
        executor.setMaxPoolSize(5);
        executor.setQueueCapacity(100);
        executor.setWaitForTasksToCompleteOnShutdown(true);
        executor.setThreadNamePrefix("AsyncThread-");
        executor.initialize();
        return executor;
    }
}
```

```java
public class ContextCopyingDecorator implements TaskDecorator {
    @Override
    public Runnable decorate(Runnable runnable) {
        RequestAttributes context = RequestContextHolder.currentRequestAttributes();
        return () -> {
            try {
                RequestContextHolder.setRequestAttributes(context);
                runnable.run();
            } finally {
                RequestContextHolder.resetRequestAttributes();
            }
        };
    }
}

```

**具体代码中使用**

```java
public class OrderService{
    @Async(AsyncThreadConfig.ASYNC_EXECUTOR_NAME)
    public void syncUserAsync(String userId) {
    // TODO 在这里执行具体的业务逻辑
    }
}
```
**扩展**

```text
# 异步注解通过AsyncResult返回Future对象
@Async(value = AsyncThreadConfig.ASYNC_EXECUTOR_NAME)
    public Future<String> test2(){
        log.info("Async.test2线程开始了");
        return new AsyncResult<>("发送消息用了+test2秒");
    }

```

## 使用@Async注解需要注意点

```text
1. 禁止在@Transactional注解的事务中进行执行，因为@Transactional注解也是通过
AOP的方式进行切割处理的，此时由于事务具备传播则会失效当前的@Async，所以我们的
解决办法就是再另外创建一个异步处理操作的service,然后进行访问.

```

