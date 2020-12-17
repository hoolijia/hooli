package com.hooli.order.service;

/**
 * @author ：hooli
 * @date ：Created in 2020/12/16 3:08 下午
 * @description：订单接口
 */
public interface IOrderService {

    String createOrder(Long productId, Long userId, Integer stockCount, Integer creditCount);
}
