# springboot集成prometheus进行监控
- 添加对应的依赖
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
<!--将actuator中的指标信息信息转换成标准的prometheus -->
<dependency>
    <groupId>io.micrometer</groupId>
    <artifactId>micrometer-registry-prometheus</artifactId>
    <scope>runtime</scope>
</dependency>
```
- 将当前服务名为当前服务打入prometheus标识
```java
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: chao
 * @description: prometheus的bean配置化
 * @create: 2020-11-06 11:15
 */
@Configuration
public class PrometheusBeanConfig {
    @Bean
    MeterRegistryCustomizer<MeterRegistry> configurer(@Value("${spring.application.name}") String applicationName) {
        return (registry) -> registry.config().commonTags("application", applicationName);
    }
}
```

- 自定义指标信息
```java
@Component
public class JobMetrics implements MeterBinder {
    public Counter job1Counter;
    public Counter job2Counter;

    public Map<String, Double> map;

    JobMetrics() {
        map = new HashMap<>();
    }

    @Override
    public void bindTo(MeterRegistry meterRegistry) {
        this.job1Counter = Counter.builder("counter_builder_job_counter1")
                .tags(new String[]{"name", "tag_job_counter1"})
                .description("description-Job counter1 execute count").register(meterRegistry);

        this.job2Counter = Counter.builder("counter_builder_job_counter2")
                .tags(new String[]{"name", "tag_job_counter2"})
                .description("description-Job counter2 execute count ").register(meterRegistry);

        Gauge.builder("gauge_builder_job_gauge", map, x -> x.get("x"))
                .tags("name", "tag_job_gauge")
                .description("description-Job gauge")
                .register(meterRegistry);
    }

}
```
- 

- 开启actuator的权限功能，默认只能查看info
```yaml
spring:
  application:
    name: ocean-prometheus

management:
  endpoints:
    # 监控权限开启
    web:
      exposure:
        include: '*'
    # 指标监控开启
    jmx:
      exposure:
        include: '*'
  metrics:
    tags:
      application: ${spring.application.name}
  endpoint:
    shutdown:
      enabled: true
info:
  author: jack


```


```shell script
curl -XGET http://localhost:8080/actuator/prometheus
# HELP jvm_memory_max_bytes The maximum amount of memory in bytes that can be used for memory management
# TYPE jvm_memory_max_bytes gauge
jvm_memory_max_bytes{application="ocean-prometheus",area="heap",id="PS Survivor Space",} 1.2058624E7
jvm_memory_max_bytes{application="ocean-prometheus",area="heap",id="PS Old Gen",} 2.863661056E9
jvm_memory_max_bytes{application="ocean-prometheus",area="heap",id="PS Eden Space",} 1.407188992E9
jvm_memory_max_bytes{application="ocean-prometheus",area="nonheap",id="Metaspace",} -1.0
jvm_memory_max_bytes{application="ocean-prometheus",area="nonheap",id="Code Cache",} 2.5165824E8
jvm_memory_max_bytes{application="ocean-prometheus",area="nonheap",id="Compressed Class Space",} 1.073741824E9
# HELP system_load_average_1m The sum of the number of runnable entities queued to available processors and the number of runnable entities running on the available processors averaged over a period of time
# TYPE system_load_average_1m gauge
system_load_average_1m{application="ocean-prometheus",} 2.96533203125
# HELP jvm_buffer_count_buffers An estimate of the number of buffers in the pool
# TYPE jvm_buffer_count_buffers gauge
jvm_buffer_count_buffers{application="ocean-prometheus",id="direct",} 4.0
jvm_buffer_count_buffers{application="ocean-prometheus",id="mapped",} 0.0
```

# prometheus添加拉去当前服务的prometheus监控指标信息

- 添加拉取配置
```yaml
vim prometheus.yml

scrape_configs:
# 通过该配置拉取当前的指标信息
  - job_name: 'ocean-prometheus' 
    scrape_interval: 5s
    # actuator开放的prometheus监控指标
    metrics_path: '/actuator/prometheus'
    static_configs:
      # 拉去的服务地址
      - targets: ['localhost:8080']
```
- 通过prometheus的界面进行指标信息的查看

```
http://localhost:9090/
# 通过promQL语句进行查询
sum(up{job="ocean-prometheus"})
```

# 通过grafana进行监控指标数据的展示
- 添加prometheus数据源
```
1. 下载springboot的监控模版 4701  
```

![jack](images/2020-11-06 11.39.08.gif)



