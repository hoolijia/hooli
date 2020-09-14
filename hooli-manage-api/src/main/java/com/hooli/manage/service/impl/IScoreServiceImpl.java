package com.hooli.manage.service.impl;

import com.hooli.manage.service.IScoreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author ：hooli
 * @date ：Created in 2020/9/14 2:46 下午
 * @description：积分处理实现
 */
@Service
@Slf4j
public class IScoreServiceImpl implements IScoreService {

    @Async
    @Override
    public void addScore() {
        // TODO 模拟添加积分
        try {
            Thread.sleep(1000 * 3);
            log.info("----------- 积分处理 ------------");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Async("scorePoolTaskExecutor")
    @Override
    public void addScore2() {
        try {
            Thread.sleep(1000 * 3);
            log.info("----------- 积分处理 ------------");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
