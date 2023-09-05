package com.javase.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

/**
 * @author ：panleilei
 * @description
 * @modified By：
 * @version:
 * @date ：Created in 2023/7/12 9:22
 */
public class SocketTest2 {
    public static void main(String[] args) throws IOException {
        String ip = "127.0.0.1";
        int port = 10050;
        SocketAddress socketAddress = new InetSocketAddress(ip,port);
        Socket socket = new Socket();
        socket.connect(socketAddress);
        System.out.println("====");
    }
}
