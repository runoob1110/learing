package com.learn.server.tcp;

import com.learn.server.Server;

import java.io.IOException;
import java.net.*;

/**
 * @author ：panleilei
 * @description
 * @modified By：
 * @version:
 * @date ：Created in 2024/11/11 17:22
 */
public class TcpServer implements Server {
    @Override
    public void start() {
//        ServerSocket socket = null;
//        try {
//            socket = new ServerSocket();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//
//        ServerSocket finalSocket = socket;
//        new Thread(() -> {
//            while (!finalSocket.isClosed()) {
//                try {
//                    Socket socket1 = finalSocket.accept();
//                    socket1.getInputStream();
//                } catch (IOException e) {
//                    throw new RuntimeException(e);
//                }
//
//
//                // 持续接收消息
//                byte[] receivedData = new byte[RECEIVE_BUFFER];
//                DatagramPacket packet = new DatagramPacket(receivedData, receivedData.length);
//                try {
//                    finalSocket.receive(packet);
//                    byte[] data = packet.getData();
//                    int len = packet.getLength();
//                    String reveivedString = new String(data, 0, len);
//                    sendMessageToListeners(reveivedString);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//            finalSocket.close();
//            finalSocket.isClosed();
//        }).start();
    }
}
