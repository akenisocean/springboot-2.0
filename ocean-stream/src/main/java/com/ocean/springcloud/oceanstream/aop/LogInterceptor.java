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
