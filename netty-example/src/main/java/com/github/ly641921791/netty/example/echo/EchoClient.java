package com.github.ly641921791.netty.example.echo;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import lombok.AllArgsConstructor;

/**
 * @author ly
 */
@AllArgsConstructor
public class EchoClient {

    private final String host;
    private final int port;

    public static void main(String[] args) throws Exception {
        new EchoClient("127.0.0.1", 8080).start();
    }

    private void start() throws Exception {
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(group)
                    .channel(NioSocketChannel.class)
                    .remoteAddress(host, port)
                    // 添加处理器
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(new EchoClientHandler());
                        }
                    });
            // 连接远程节点，阻塞直到连接完成
            ChannelFuture future = bootstrap.connect().sync();
            // 阻塞直到关闭
            future.channel().closeFuture().sync();
        } finally {
            // 关闭线程池并释放资源
            group.shutdownGracefully();
        }
    }

}
