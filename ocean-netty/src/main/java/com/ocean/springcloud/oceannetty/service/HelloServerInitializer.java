package com.ocean.springcloud.oceannetty.service;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;


/**
 * @author 季超
 * @create 2018-11-09 21:32
 * @desc 初始化器,channel注册后，会执行里面相应的初始化方法
 **/
public class HelloServerInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel channel) throws Exception {
        //通过SocketChannelu获得对应的pipeline管道
        ChannelPipeline pipeline = channel.pipeline();

        //通过管道添加handler
        //HttpServerCodec是由netty自己提供的助手类，可以理解为拦截器
        // 当请求服务器，我们需要做解码，相应到客户端需要做编码
        pipeline.addLast("HttpServerCodec",new HttpServerCodec());

        //添加自定义的handler
        pipeline.addLast("customHandler",new CustomHandler());

    }
}
