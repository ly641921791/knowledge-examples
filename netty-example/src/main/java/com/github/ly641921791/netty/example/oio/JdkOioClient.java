package com.github.ly641921791.netty.example.oio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author ly
 */
public class JdkOioClient {

    public static void main(String[] args) throws IOException {
        Socket clientSocket = new Socket("localhost", 8080);
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        out.println("【这是一个请求内容】");
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        System.out.println(in.readLine());
    }

}
