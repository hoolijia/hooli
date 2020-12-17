package com.hooli.order.feign;

import com.hooli.order.feign.fallback.CreditServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author ：hooli
 * @date ：Created in 2020/12/16 5:46 下午
 * @description：积分服务接口
 */
@FeignClient(value = "hooli-credit-service", fallback = CreditServiceFallback.class)
public interface CreditService {

    @PostMapping(value = "/credit/add")
    String addCredit(@RequestParam("userId") Long userId, @RequestParam("creditCount") Integer creditCount);
}
