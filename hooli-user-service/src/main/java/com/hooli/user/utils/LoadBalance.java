package com.hooli.user.utils;

import java.util.List;

/**
 * @author ：hooli
 * @date ：Created in 2020/11/12 4:37 下午
 * @description： 负责均衡抽象类
 */
public abstract class LoadBalance {

    public volatile static List<String> SERVICE_LIST;

    public abstract String choseServiceHost();
}
