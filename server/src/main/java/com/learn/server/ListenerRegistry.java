package com.learn.server;

/**
 * @author ：panleilei
 * @description
 * @modified By：
 * @version:
 * @date ：Created in 2024/11/6 15:15
 */
public interface ListenerRegistry {
    void registerListener(MessageListener listener);
}
