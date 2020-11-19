package com.hooli.manage;

import com.hooli.manage.test.redis.resp.EnjoyRedisClient;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import redis.clients.jedis.Jedis;

import java.io.IOException;

/**
 * @author ：hooli
 * @date ：Created in 2020/11/13 10:38 上午
 * @description：
 */
@SpringBootTest
public class RedisTest {

    @Test
    public void jedis() {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        jedis.set("hooli1", "hi hooli");
        String value = jedis.get("hooli1");
        System.out.println("返回结果：" + value);
        jedis.close();
    }

    @Test
    public void splitTest1() {
        Jedis jedis = new Jedis("127.0.0.1", 11000);
        String response = jedis.set("a", "hooli");
        jedis.close();
        System.out.println("返回结果：" + response);
    }

    @Test
    public void splitTest2() {
        Jedis jedis = new Jedis("127.0.0.1", 11000);
        String response = jedis.set("b", "hi hooli");
        jedis.close();
        System.out.println("返回结果：" + response);
    }

    // 测试自己写的客户端
    @Test
    public void enjoyRedisClientTest() throws Exception {
        EnjoyRedisClient redisClient = new EnjoyRedisClient();
        redisClient.set("hooli", "iLoveU");

        String value = redisClient.get("hooli");
        System.out.println("##### 开始打印 #####");
        System.out.println(value);
        System.out.println("##### 打印结束 #####");
    }
}
