package com.ocean.springcloud.oceangateway;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.ocean.springcloud.oceangateway.limitresolver.HostAddrKeyResolver;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;


@SpringCloudApplication
@RestController
public class OceanGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(OceanGatewayApplication.class, args);
    }


    @HystrixCommand(commandKey = "fallbackcmd")
    public String fallbackcmd() {
        return "fallbackcmd.laji";
    }


    @Bean(name = "hostAddrKeyResolver")
    public HostAddrKeyResolver hostAddrKeyResolver() {
        return new HostAddrKeyResolver();
    }

//	@Bean
//	public RateLimiter myRateLimiter(){
//		return new MyRateLimiter();
//	}

//	@Bean(name = "uriKeyResolver")
//	public UriKeyResolver uriKeyResolver() {
//		return new UriKeyResolver();
//	}

//	@Bean
//	public KeyResolver userKeyResolver() {
//		return exchange -> Mono.just(exchange.getRequest().getQueryParams().getFirst("user"));
//	}

}

