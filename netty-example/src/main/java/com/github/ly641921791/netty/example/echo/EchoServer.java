package com.github.ly641921791.netty.example.echo;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import lombok.AllArgsConstructor;

/**
 * @author ly
 */
@AllArgsConstructor
public class EchoServer {

    private final int port;

    public static void main(String[] args) throws Exception {
        new EchoServer(8080).start();
    }

    private void start() throws Exception {
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(group)
                    .channel(NioServerSocketChannel.class)
                    .localAddress(port)
                    // 添加处理器
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(new EchoServerHandler());
                        }
                    });
            // 异步绑定，阻塞等待直到完成
            ChannelFuture future = bootstrap.bind().sync();
            // 关闭直到完成
            future.channel().closeFuture().sync();
        } finally {
            // 关闭并释放全部资源
            group.shutdownGracefully().sync();
        }
    }

}
