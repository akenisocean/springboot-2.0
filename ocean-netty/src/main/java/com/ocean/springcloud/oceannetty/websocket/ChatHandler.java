package com.ocean.springcloud.oceannetty.websocket;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.util.concurrent.GlobalEventExecutor;

import java.time.LocalDateTime;

/**
 * @author jack chao
 * @create 2018-11-10 10:16
 * @desc 处理聊天消息的handler
 * TextWebSocketFrame: websocket中处理文本的对象
 **/
public class ChatHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {

    private static ChannelGroup clients = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, TextWebSocketFrame textSocket) throws Exception {
        //获取客户端发送过来的字符串
        String content = textSocket.text();
        System.err.println("接受到客户端的数据："+content.toString());

        for (Channel channel: clients) {
            channel.writeAndFlush(new TextWebSocketFrame("【服务器再】："+ LocalDateTime.now()+"接受到消息,消息为："+content));
        }

    }


    /**
     * 当客户端连接之后（打开连接）
     * @param ctx channle的全局上下文
     * @throws Exception
     */
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        clients.add(ctx.channel());
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        clients.remove(ctx.channel());
        System.err.println(ctx.channel().id()+"已经移除");
    }
}
