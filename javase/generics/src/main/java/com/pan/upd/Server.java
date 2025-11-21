package com.pan.upd;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * @author ：panleilei
 * @description
 * @modified By：
 * @version:
 * @date ：Created in 2024/11/8 16:12
 */
public class Server implements Tcp,Udp {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(10000);
        DatagramPacket packet = new DatagramPacket(new byte[1024],1024);
        while (true) {
            socket.receive(packet);
            int length = packet.getLength();
            System.out.println(length);
            String str_recv = new String(packet.getData(), 0, length);
            System.out.println(str_recv);
        }
    }

    @Override
    public void on() {

    }
}
