package com.ocean.springcloud.oceangateway.filter;

/**
 * @author 季超
 * @create 2018-12-19 19:45
 * @desc
 **/
public class PostGatewayFilterFactory /*extends AbstractGatewayFilterFactory<PostGatewayFilterFactory.Config>*/ {

    /*public PostGatewayFilterFactory() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        // grab configuration from Config object
        return (exchange, chain) -> {
            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                ServerHttpResponse response = exchange.getResponse();
                //Manipulate the response in some way
            }));
        };
    }

    public static class Config {
        //Put the configuration properties for your filter here
    }*/

}
