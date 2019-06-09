package com.github.ly641921791.netty.example.nio;

import lombok.AllArgsConstructor;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author ly
 */
@AllArgsConstructor
public class JdkNioServer {

    private final int port;

    private void start() throws IOException {
        ServerSocketChannel socketChannel = ServerSocketChannel.open();
        socketChannel.configureBlocking(false);
        // 绑定端口
        socketChannel.bind(new InetSocketAddress(port));

        // 创建选择器并将通过注册
        Selector selector = Selector.open();
        socketChannel.register(selector, SelectionKey.OP_ACCEPT);

        for (; ; ) {
            // 等待事件，阻塞持续到下一个传入事件
            selector.select();

            // 获得全部接收事件的实例
            Set<SelectionKey> readyKeys = selector.selectedKeys();

            Iterator<SelectionKey> iterator = readyKeys.iterator();
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                iterator.remove();

                // 检查事件是否是新的已经就绪的连接
                if (key.isAcceptable()) {
                    ServerSocketChannel server = (ServerSocketChannel) key.channel();
                    SocketChannel client = server.accept();
                    client.configureBlocking(false);
                    client.register(
                            selector,
                            SelectionKey.OP_WRITE | SelectionKey.OP_READ,
                            ByteBuffer.wrap("Server received message".getBytes()));

                    System.out.println("Accepted connection from " + client);
                }

                if (key.isWritable()) {
                    SocketChannel client = (SocketChannel) key.channel();
                    ByteBuffer buffer = (ByteBuffer) key.attachment();
                    while (buffer.hasRemaining()) {
                        if (client.write(buffer) == 0) {
                            break;
                        }
                    }
                    client.close();
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        new JdkNioServer(8080).start();
    }

}
