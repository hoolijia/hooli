package com.hooli.stock.service;

/**
 * @author ：hooli
 * @date ：Created in 2020/10/28 3:33 下午
 * @description：
 */
public interface IStockService {

    Object deductStock(Long productId, Integer stockCount);
}
