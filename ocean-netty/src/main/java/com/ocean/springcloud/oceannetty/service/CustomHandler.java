package com.ocean.springcloud.oceannetty.service;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;

/**
 * @author jack chao
 * @create 2018-11-09 21:51
 * @desc 创建自定义handler
 **/
// SimpleChannelInboundHandler：对于请求来说，其实相当于[入站，入境]
public class CustomHandler extends SimpleChannelInboundHandler<HttpObject> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, HttpObject msg) throws Exception {
        //获取channel
        Channel channel = ctx.channel();
        //显示客户端的远程地址
        System.out.println(channel.remoteAddress());

        //通过缓冲区发送消息和接受消息
        ByteBuf content = Unpooled.copiedBuffer("Hello netty~ ", CharsetUtil.UTF_8);
        //构建一个http response
        FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK,content);
        //为响应增加一个数据类型和长度
        response.headers().set(HttpHeaderNames.CONTENT_TYPE,"text/plain");
        response.headers().set(HttpHeaderNames.CONTENT_LENGTH,content.readableBytes());
    }
}
