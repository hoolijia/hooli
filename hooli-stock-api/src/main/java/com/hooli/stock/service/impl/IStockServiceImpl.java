package com.hooli.stock.service.impl;

import com.hooli.core.utils.ResponseUtil;
import com.hooli.stock.service.IStockService;
import org.springframework.stereotype.Service;

/**
 * @author ：hooli
 * @date ：Created in 2020/10/28 3:33 下午
 * @description：
 */
@Service
public class IStockServiceImpl implements IStockService {

    @Override
    public Object deductStock(Long productId, Integer stockCount) {

        System.out.println("商品：" + productId + "扣减：" + stockCount + "件");

        return ResponseUtil.ok("扣减成功");
    }
}
