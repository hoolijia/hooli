package com.hooli.order.service.impl;

import com.hooli.order.feign.CreditService;
import com.hooli.order.feign.StockService;
import com.hooli.order.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author ：hooli
 * @date ：Created in 2020/12/16 3:10 下午
 * @description：订单接口实现
 */
@Service
public class IOrderServiceImpl implements IOrderService {

    @Autowired
    private StockService stockService;
    @Autowired
    @Qualifier("creditServiceFallback")
    private CreditService creditService;

    @Override
    public String createOrder(Long productId, Long userId, Integer stockCount, Integer creditCount) {
        System.out.println("订单创建成功");
        stockService.deductStock(productId, stockCount);
        creditService.addCredit(userId, creditCount);

        return "success";
    }
}
