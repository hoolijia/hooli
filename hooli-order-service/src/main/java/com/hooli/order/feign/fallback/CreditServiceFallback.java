package com.hooli.order.feign.fallback;

import com.hooli.order.feign.CreditService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * @author ：hooli
 * @date ：Created in 2020/12/16 5:50 下午
 * @description：积分服务降级
 */
@Component
@Qualifier("creditServiceFallback")
public class CreditServiceFallback implements CreditService {

    @Override
    public String addCredit(Long userId, Integer creditCount) {
        // TODO 记录降级日志，后续自动补偿
        System.out.println("调用加积分服务失败，记录日志降级处理：userId=" + userId + "，creditCount：" + creditCount);

        return "error";
    }
}
