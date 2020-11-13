package com.hooli.manage.test.redis.split;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：hooli
 * @date ：Created in 2020/11/13 11:32 上午
 * @description：Redis分库
 */
public class RedisProxy {

    private static List<String> serverList = new ArrayList<>();

    static {
        serverList.add("127.0.0.1:6379");
        serverList.add("127.0.0.1:6380");
        serverList.add("127.0.0.1:6381");
    }
}
