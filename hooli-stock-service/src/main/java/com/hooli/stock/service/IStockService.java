package com.hooli.stock.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author ：hooli
 * @date ：Created in 2020/10/28 3:33 下午
 * @description： 库存接口
 */
public interface IStockService {

    Object deductStock(Long productId, Integer stockCount);
}
