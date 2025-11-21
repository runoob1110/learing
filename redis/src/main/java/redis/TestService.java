package redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @author ：panleilei
 * @description
 * @modified By：
 * @version:
 * @date ：Created in 2023/11/6 16:14
 */
@Service
public class TestService {
    @Autowired
    private StringRedisTemplate redisTemplate;

    public void test() {
        while (true) {
            String s = redisTemplate.opsForValue().get("asc:agentframe:gjnlahql");
            System.out.println(s);
        }
    }
}
