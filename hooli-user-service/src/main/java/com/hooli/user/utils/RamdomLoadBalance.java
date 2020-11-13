package com.hooli.user.utils;

import cn.hutool.core.collection.CollUtil;

import java.util.Collections;
import java.util.Random;

/**
 * @author ：hooli
 * @date ：Created in 2020/11/12 4:36 下午
 * @description：随机算法
 */
public class RamdomLoadBalance extends LoadBalance {

    @Override
    public String choseServiceHost() {
        String result = "";

        // 判断zk列表是否为空
        if (CollUtil.isNotEmpty(SERVICE_LIST)){
            int index = new Random().nextInt(SERVICE_LIST.size());
            result = SERVICE_LIST.get(index);
        }

        return result;
    }
}
