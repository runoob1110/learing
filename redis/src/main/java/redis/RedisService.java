package redis;

import org.springframework.stereotype.Service;

/**
 * @author ：panleilei
 * @description
 * @modified By：
 * @version:
 * @date ：Created in 2023/11/6 16:21
 */
@Service
public class RedisService {


    // 接受Redis订阅的消息
    public void receiveSubsMessage(String message, String type) {
        System.out.println(message);
    }
}
