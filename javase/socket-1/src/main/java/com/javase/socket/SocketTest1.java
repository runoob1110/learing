package com.javase.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author ：panleilei
 * @description
 * @modified By：
 * @version:
 * @date ：Created in 2023/7/12 9:20
 */
public class SocketTest1 {
    public static void main(String[] args) throws IOException {
        int port = 10050;
        ServerSocket serverSocket = new ServerSocket(port);
        Socket accept = serverSocket.accept();

        System.out.println("====");
    }
}
