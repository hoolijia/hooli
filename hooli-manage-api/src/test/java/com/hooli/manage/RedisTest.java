package com.hooli.manage;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import redis.clients.jedis.Jedis;

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
}
