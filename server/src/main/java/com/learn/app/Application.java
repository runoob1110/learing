package com.learn.app;

import com.learn.server.udp.UdpServer;

/**
 * @author ：panleilei
 * @description
 * @modified By：
 * @version:
 * @date ：Created in 2024/11/8 16:59
 */
public class Application {
    public static void main(String[] args) {
        UdpServer server = new UdpServer();
        server.registerListener(new Listener());
        server.start();
    }
}
