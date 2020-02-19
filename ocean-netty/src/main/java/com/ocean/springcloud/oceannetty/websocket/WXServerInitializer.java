package com.ocean.springcloud.oceannetty.websocket;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.codec.http.websocketx.extensions.compression.WebSocketServerCompressionHandler;
import io.netty.handler.stream.ChunkedWriteHandler;

/**
 * @author jack chao
 * @create 2018-11-10 9:03
 * @desc
 **/
public class WXServerInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        ChannelPipeline pipeline = socketChannel.pipeline();
        // websocket基于http协议，所以要有http编解码器
        pipeline.addLast(new HttpServerCodec());
        //对写大数据流的支持
        pipeline.addLast(new ChunkedWriteHandler());
        //对HttpMessage聚合，聚合成FullHttpRequest或FullHttpResponse
        //几乎在netty中的编程，都会使用到此handler
        pipeline.addLast("aggregator", new HttpObjectAggregator(1024 * 64));

        //--------------------以上时支持Http协议---------------------------------
        //websocket处理的协议，并且指定客户端连接访问的路由：/ws
        pipeline.addLast(new WebSocketServerProtocolHandler("/ws"));

        //添加自定义的handler
        pipeline.addLast(new ChatHandler());

    }
}
