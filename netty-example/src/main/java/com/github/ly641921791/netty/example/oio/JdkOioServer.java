package com.github.ly641921791.netty.example.oio;

import lombok.AllArgsConstructor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author ly
 */
@AllArgsConstructor
public class JdkOioServer {

    private final int port;

    private void start() throws IOException {
        // 创建服务端并指定端口
        final ServerSocket serverSocket = new ServerSocket(port);

        // 阻塞接收客户端连接
        final Socket clientSocket = serverSocket.accept();

        System.out.println("Accepted connection from " + clientSocket);

        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

        final String message = in.readLine();
        System.out.println("Received message from client :" + message);
        out.println("Handle message :" + message);
    }

    public static void main(String[] args) throws IOException {
        new JdkOioServer(8080).start();
    }

}
