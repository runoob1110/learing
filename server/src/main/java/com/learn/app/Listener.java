package com.learn.app;

import com.learn.server.CommunicationMessage;
import com.learn.server.MessageListener;

/**
 * @author ：panleilei
 * @description
 * @modified By：
 * @version:
 * @date ：Created in 2024/11/8 17:03
 */
public class Listener implements MessageListener {
    @Override
    public void onMessage(CommunicationMessage message) {
        System.out.println(message.getMessage());
    }

    @Override
    public void onError(CommunicationMessage message) {

    }
}
