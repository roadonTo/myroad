package road.on;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootTest
public class WebTest {

    //引入redis依赖后，可以直接注入这个redis的模板使用
    @Autowired
    private StringRedisTemplate redisTemplate;


    @Test
    public void TestRedis(){
        redisTemplate.opsForValue().set("name","凯撒");
    }

    @Test
    public void TestRedisGetValue(){
        String name = redisTemplate.opsForValue().get("name");
        System.out.println(name);
    }


}
