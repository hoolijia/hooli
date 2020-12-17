package com.hooli.order.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author ：hooli
 * @date ：Created in 2020/12/16 3:00 下午
 * @description：库存接口
 */
@FeignClient(value = "hooli-stock-service")
public interface StockService {

    @PostMapping(value = "/stock/deduct")
    String deductStock(@RequestParam("productId") Long productId, @RequestParam("stockCount") Integer stockCount);
}
