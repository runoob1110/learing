package com.learn.server.udp;

import com.learn.server.CommunicationMessage;
import com.learn.server.ListenerRegistry;
import com.learn.server.MessageListener;
import com.learn.server.Server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ：panleilei
 * @description
 * @modified By：
 * @version:
 * @date ：Created in 2024/11/6 15:11
 */
public class UdpServer implements Server, ListenerRegistry {
    /** 默认监听10060端口 **/
    private static final int defaultListenedPort = 10060;
    private static final int RECEIVE_BUFFER = 64 * 1024;
    private int listenedPort = defaultListenedPort;
    private List<MessageListener> listeners = new ArrayList<>(16);
    public UdpServer() {
    }

    public UdpServer(int listenedPort) {
        this.listenedPort = listenedPort;
    }

    @Override
    public void start() {
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket(listenedPort);
        } catch (SocketException e) {
            throw new RuntimeException(e);
        } finally {
            // todo 发送socket关闭通知
        }
        DatagramSocket finalSocket = socket;
        new Thread(() -> {
            while (!finalSocket.isClosed()) {
                // 持续接收消息
                byte[] receivedData = new byte[RECEIVE_BUFFER];
                DatagramPacket packet = new DatagramPacket(receivedData, receivedData.length);
                try {
                    finalSocket.receive(packet);
                    byte[] data = packet.getData();
                    int len = packet.getLength();
                    String reveivedString = new String(data, 0, len);
                    sendMessageToListeners(reveivedString);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            finalSocket.close();
            finalSocket.isClosed();
        }).start();
    }

    /**
     * 给所有的监听者发送消息
     * @param str
     */
    private void sendMessageToListeners(String str){
        for (MessageListener listener : listeners) {
            CommunicationMessage message = new CommunicationMessage() {
                @Override
                public String getType() {
                    return "";
                }

                @Override
                public String getMessage() {
                    return str;
                }

            };
            listener.onMessage(message);
        }
    }

    @Override
    public void registerListener(MessageListener listener) {
        this.listeners.add(listener);
    }
}
