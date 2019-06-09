package com.github.ly641921791.netty.example.nio;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.util.CharsetUtil;

/**
 * @author ly
 */
public class NettyNioServer {

    public static void main(String[] args) throws Exception{
        EventLoopGroup group = new NioEventLoopGroup();                 // *

        try {
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap
                .group(group).channel(NioServerSocketChannel.class) // *
                .localAddress(8080)
                .childHandler(
                    new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch)
                                throws Exception {
                            ch.pipeline().addLast(
                                new ChannelInboundHandlerAdapter() {
                                    @Override
                                    public void channelActive(ChannelHandlerContext ctx) throws Exception {
                                        ctx
                                            .writeAndFlush(Unpooled.copiedBuffer("Hi!\r\n", CharsetUtil.UTF_8).duplicate())
                                            .addListener(ChannelFutureListener.CLOSE);
                                    }
                                }
                            );
                        }
                    }
                );
            ChannelFuture future = bootstrap.bind().sync();
            future.channel().closeFuture().sync();
        } finally {
            group.shutdownGracefully().sync();
        }
    }

}
