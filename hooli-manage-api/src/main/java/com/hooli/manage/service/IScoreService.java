package com.hooli.manage.service;

/**
 * @author ：hooli
 * @date ：Created in 2020/9/14 2:44 下午
 * @description：积分处理
 */
public interface IScoreService {

    /**
     * @author     ：hooli
     * @date       ：Created in 2020/9/14 3:03 下午
     * @description：普通异步处理，使用默认线程池
     */
    void addScore();

    /**
     * @author     ：hooli
     * @date       ：Created in 2020/9/14 3:05 下午
     * @description：指定线程池
     */
    void addScore2();

}
