package com.hooli.stock.api;

import com.hooli.stock.service.IStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：hooli
 * @date ：Created in 2020/10/28 3:31 下午
 * @description：
 */
@RestController
@RequestMapping("/stock")
public class StockController {

    @Autowired
    private IStockService iStockService;

    @GetMapping(value = "/deduct/{productId}/{stockCount}")
    public Object deductStock(@PathVariable("productId") Long productId, @PathVariable("stockCount") Integer stockCount) {

        return iStockService.deductStock(productId, stockCount);
    }
}
