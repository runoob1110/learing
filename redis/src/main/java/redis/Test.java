package redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

/**
 * @author ：panleilei
 * @description
 * @modified By：
 * @version:
 * @date ：Created in 2023/11/6 16:07
 */
@SpringBootApplication
public class Test implements CommandLineRunner {
    @Autowired
    private RedisMessageListenerContainer container;
    @Autowired
    private MessageListenerAdapter listenerAdapter;
//    private String statusMessage = "asc:agentframe:*";
    private String statusMessage = "asc:status/pattern:*";

    @Autowired
    private TestService testService;
    public static void main(String[] args) {
        SpringApplication.run(Test.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        container.addMessageListener(listenerAdapter, new PatternTopic(statusMessage));

    }
}
