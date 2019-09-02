package com.ocean.springcloud.oceangateway.filter;

/**
 * @author 季超
 * @create 2018-12-19 19:44
 * @desc
 **/
public class PreGatewayFilterFactory /*extends AbstractGatewayFilterFactory<PreGatewayFilterFactory.Config>*/ {

   /* public PreGatewayFilterFactory() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        // grab configuration from Config object
        return (exchange, chain) -> {
            //If you want to build a "pre" filter you need to manipulate the
            //request before calling change.filter
            ServerHttpRequest.Builder builder = exchange.getRequest().mutate();
            //use builder to manipulate the request
            ServerHttpRequest request = builder.build();
            return chain.filter(exchange.mutate().request(request).build());
        };
    }

    public static class Config {
        //Put the configuration properties for your filter here
    }*/

}