package com.hooli.stock.api;

import com.hooli.stock.service.IStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(value = "/deduct")
    public Object deductStock(Long productId, Integer stockCount) {

        return iStockService.deductStock(productId, stockCount);
    }
}
