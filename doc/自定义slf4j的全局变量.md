# 说明
日志文件默认情况下通过线程上下文做日志的统一保存，那么可以通过内部不同的日志服务根据业务做不同
的参数上下文传递，服务的链路调用大致也是通过这种全局上下文方式来进行实现。

## Slf4j的上下文使用`org.slf4j.MDC`进行上下文日志跟踪

什么是MDC机制?
```text
MDC（Mapped Diagnostic Contexts）映射诊断上下文，主要用在做日志链路跟踪时，动态配置用户自定义的一些信息，比如requestId、sessionId等等。MDC使用的容器支持多线程操作，满足线程安全。
```

### 样例
```java

package com.ocean.springcloud.oceanstream.aop;

import org.apache.logging.log4j.ThreadContext;
import org.slf4j.MDC;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author chao
 * @description
 * @create 2021-06-08 13:21
 */
public class LogInterceptor implements HandlerInterceptor {
    private final static String TRACE_ID = "traceId";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        /**
         * 添加一个调用链id，方便后续做链路追踪
         */
        String traceId = java.util.UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
        MDC.put("traceId", traceId);
        return true;
    }


    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        ThreadContext. remove(TRACE_ID);
    }
}

```

将日志拦截器添加到请求拦截器中
```java
package com.ocean.springcloud.oceanstream.aop;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author chao
 * @description
 * @create 2021-06-08 13:37
 */
@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LogInterceptor());
    }
}

```

在logback日志文件中通过`X`变量获取当前放入MDC中的上下文信息
```xml
<?xml version="1.0" encoding="UTF-8"?>
<configuration>
    <include resource="org/springframework/boot/logging/logback/base.xml"/>

    <springProperty scope="context" name="spring.application.name" source="spring.application.name"/>

    <property name="APP_NAME" value="${spring.application.name}"/>
    <property name="LOG_FILE" value="${APP_NAME}"/>
    <property name="LOG_PATH" value="./logs"/>
    <property name="LOG_PATTERN_CONSOLE"
              value="${LOG_PATTERN_CONSOLE:-%clr(%d{${LOG_DATEFORMAT_PATTERN:-yyyy-MM-dd HH:mm:ss.SSS}}){faint} %clr(${[%X{traceId}]}) %clr(${LOG_LEVEL_PATTERN:-%5p}) %clr(${PID:- }){magenta}  %clr([${APP_NAME}]){magenta} %clr(---){faint} %clr([%15.15t]){faint} %clr(%-40.40logger{39}){cyan} %clr(:){faint} %m%n${LOG_EXCEPTION_CONVERSION_WORD:-%wEx}}"/>
    <property name="LOG_PATTERN_FILE"
              value="${LOG_PATTERN_FILE:-%d{${LOG_DATEFORMAT_PATTERN:-yyyy-MM-dd HH:mm:ss.SSS}} [TRACEID:%X{traceId}] ${LOG_LEVEL_PATTERN:-%5p} ${PID:- } [${APP_NAME}] ------ [%t] %-40.40logger{39} : %m%n${LOG_EXCEPTION_CONVERSION_WORD:-%wEx}}"/>
    <!--    <property name="LOG_PATTERN_CONSOLE" value="%d{yyyy-MM-dd HH:mm:ss} [%thread] %-5level 【${APP_NAME}】%logger{50} -&#45;&#45; %msg%n" />-->
    <!--    <property name="LOG_PATTERN_FILE" value="%d{yyyy-MM-dd HH:mm:ss} [%thread] %-5level 【${APP_NAME}】 %logger{50} -&#45;&#45; %msg%n" />-->
    <!--- 设置控制台日志 -->
    <appender name="consoleLog" class="ch.qos.logback.core.ConsoleAppender">
        <encoder>
            <pattern>${LOG_PATTERN_CONSOLE}</pattern>
            <charset class="java.nio.charset.Charset">UTF-8</charset>
        </encoder>
    </appender>
    <!-- 设置日志文件 -->
    <appender name="fileLog" class="ch.qos.logback.core.rolling.RollingFileAppender">
        <encoder>
            <pattern>${LOG_PATTERN_FILE}</pattern>
        </encoder>
        <!--根据每天来进行日志切割    -->
        <file>${LOG_PATH}/${LOG_FILE}.log</file>
        <rollingPolicy class="ch.qos.logback.core.rolling.TimeBasedRollingPolicy">
            <fileNamePattern>${LOG_PATH}/${LOG_FILE}-%d{yyyy-MM-dd}.log.gz</fileNamePattern>
            <!-- 设置保存10天-->
            <maxHistory>10</maxHistory>
        </rollingPolicy>
    </appender>

    <appender name="fileErrorLog" class="ch.qos.logback.core.rolling.RollingFileAppender">
        <encoder>
            <pattern>${LOG_PATTERN_FILE}</pattern>
        </encoder>
        <!--根据每天来进行日志切割    -->
        <file>${LOG_PATH}/${LOG_FILE}.error.log</file>
        <rollingPolicy class="ch.qos.logback.core.rolling.TimeBasedRollingPolicy">
            <fileNamePattern>${LOG_PATH}/${LOG_FILE}-%d{yyyy-MM-dd}.error.log.gz</fileNamePattern>
            <!-- 设置保存10天-->
            <maxHistory>10</maxHistory>
        </rollingPolicy>
        <!-- 此日志文档只记录ERROR级别的 -->
        <filter class="ch.qos.logback.classic.filter.LevelFilter">
            <level>ERROR</level>
            <onMatch>ACCEPT</onMatch>
            <onMismatch>DENY</onMismatch>
        </filter>
    </appender>
    <logger name="com.jk.di.dataflow.web.repository" level="debug"/>
    <!-- 设置日志级别，及需要记录日志的类 -->
    <root level="info">
        <!--        <appender-ref ref="consoleLog"/>-->
        <appender-ref ref="fileLog"/>
        <appender-ref ref="fileErrorLog"/>
    </root>

</configuration>

```

返回信息
```text
2021-06-08 15:44:50.444 [TRACEID:]  INFO 30297 [ocean-stream] ------ [main] c.o.s.o.OceanStreamApplication           : Starting OceanStreamApplication on changjingludeMacBook-Pro.local with PID 30297 (/Users/happygiraffe/Documents/chao/work-space/springboot-2.0/ocean-stream/target/classes started by happygiraffe in /Users/happygiraffe/Documents/chao/work-space/springboot-2.0)
2021-06-08 15:44:50.450 [TRACEID:]  INFO 30297 [ocean-stream] ------ [main] c.o.s.o.OceanStreamApplication           : No active profile set, falling back to default profiles: default
2021-06-08 15:44:53.359 [TRACEID:]  INFO 30297 [ocean-stream] ------ [main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 10000 (http)
2021-06-08 15:44:53.374 [TRACEID:]  INFO 30297 [ocean-stream] ------ [main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2021-06-08 15:44:53.375 [TRACEID:]  INFO 30297 [ocean-stream] ------ [main] org.apache.catalina.core.StandardEngine  : Starting Servlet engine: [Apache Tomcat/9.0.45]
2021-06-08 15:44:53.460 [TRACEID:]  INFO 30297 [ocean-stream] ------ [main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2021-06-08 15:44:53.461 [TRACEID:]  INFO 30297 [ocean-stream] ------ [main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 2918 ms
2021-06-08 15:44:54.087 [TRACEID:]  INFO 30297 [ocean-stream] ------ [main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 10000 (http) with context path ''
2021-06-08 15:44:54.129 [TRACEID:]  INFO 30297 [ocean-stream] ------ [main] c.o.s.o.OceanStreamApplication           : Started OceanStreamApplication in 5.268 seconds (JVM running for 9.247)
2021-06-08 15:45:11.808 [TRACEID:]  INFO 30297 [ocean-stream] ------ [http-nio-10000-exec-1] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring DispatcherServlet 'dispatcherServlet'
2021-06-08 15:45:11.811 [TRACEID:]  INFO 30297 [ocean-stream] ------ [http-nio-10000-exec-1] o.s.web.servlet.DispatcherServlet        : Initializing Servlet 'dispatcherServlet'
2021-06-08 15:45:11.832 [TRACEID:]  INFO 30297 [ocean-stream] ------ [http-nio-10000-exec-1] o.s.web.servlet.DispatcherServlet        : Completed initialization in 21 ms
2021-06-08 15:45:12.081 [TRACEID:29490109567342F4941F9CCA4954ADE1]  INFO 30297 [ocean-stream] ------ [http-nio-10000-exec-1] c.o.s.oceanstream.aop.RequestLogAspect   : Request Info : {"ip":"127.0.0.1","url":"http://localhost:10000/test/test1","httpMethod":"GET","classMethod":"com.ocean.springcloud.oceanstream.stream.collector.TestController.test1","requestParams":{},"result":{"JANUARY":"None","FEBRUARY":"None","MARCH":"None","APRIL":"None","MAY":"Jame Jason","JUNE":"None","JULY":"Jeff Jane","AUGUST":"None","SEPTEMBER":"None","OCTOBER":"None","NOVEMBER":"None","DECEMBER":"Jodd Janey"},"timeCost":67}
```

## Slf4j的上下文使用`org.apache.logging.log4j.ThreadContext`进行上下文日志跟踪

- 链接： aop做统一的日志记录操作: Spring AOP使用.md