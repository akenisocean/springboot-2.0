package com.ocean.springcloud.oceannetty;

import com.ocean.springcloud.oceannetty.service.HelloServerInitializer;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @author 季超
 * @create 2018-11-09 18:27
 * @desc netty编写
 **/
public class NettyTest {
    public static void main(String[] args) throws InterruptedException {
        //定义一个线程组
        //主线程组 用于接受客户端的连接，但是不做任何处理，和老板一样，不做事
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        //从线程组 老板组线程会把任务丢给它，它做实际的任务操作
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            //设置该启动类
            //netty服务器的创建，ServerBootstrap是一个启动类
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(bossGroup, workerGroup).//设置主从线程组
                    channel(NioServerSocketChannel.class)//设置Nio的双向通道
                    .childHandler(new HelloServerInitializer()); //子处理器，用于处理workerGroup

            //启动server,并且设置8088为启动的端口号，同时启动方式为同步
            ChannelFuture future = serverBootstrap.bind(8088).sync();
            //监听关闭channel,设置为同步方式
            future.channel().closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }

    }
}
