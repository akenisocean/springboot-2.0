package com.ocean.springcloud.oceannetty.websocket;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @author jack chao
 * @create 2018-11-09 23:02
 * @desc
 **/
public class WXServer {

    public static void main(String[] args) throws InterruptedException {
        //定义两个线程组
        EventLoopGroup mainGroup = new NioEventLoopGroup();
        EventLoopGroup subGroup = new NioEventLoopGroup();

        try {
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(mainGroup,subGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new WXServerInitializer());

            ChannelFuture future = bootstrap.bind(8080).sync();
            future.channel().closeFuture().sync();
        } finally {
             mainGroup.shutdownGracefully();
             subGroup.shutdownGracefully();
        }


    }
}
