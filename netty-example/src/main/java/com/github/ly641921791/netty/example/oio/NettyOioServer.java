package com.github.ly641921791.netty.example.oio;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.oio.OioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.oio.OioServerSocketChannel;
import io.netty.util.CharsetUtil;

/**
 * @author ly
 */
public class NettyOioServer {

    public static void main(String[] args) throws Exception{

        EventLoopGroup group = new OioEventLoopGroup();                     // *

        try {
            ServerBootstrap bootstrap = new ServerBootstrap();              // 创建引导对象
            bootstrap
                .group(group).channel(OioServerSocketChannel.class)         // *使用OioEventLoopGroup，允许阻塞模式
                .localAddress(8080)
                .childHandler(new ChannelInitializer<SocketChannel>() {         // 指定ChannelInitializer，对于每个已接手的连接都会调用
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ch.pipeline().addLast(
                            new ChannelInboundHandlerAdapter() {
                                @Override
                                public void channelActive(ChannelHandlerContext ctx)
                                        throws Exception {
                                    ctx
                                        .writeAndFlush(Unpooled.copiedBuffer("Hi!\r\n", CharsetUtil.UTF_8).duplicate())
                                        .addListener(ChannelFutureListener.CLOSE);                                     // 写完消息就关闭连接
                                }
                            }
                        );
                    }
                });
            ChannelFuture future = bootstrap.bind().sync();                 // 绑定服务器以接受连接
            future.channel().closeFuture().sync();
        } finally {
            group.shutdownGracefully().sync();                              // 释放资源
        }

    }

}
