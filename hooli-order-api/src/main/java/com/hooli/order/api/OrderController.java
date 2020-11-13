package com.hooli.order.api;

import com.hooli.order.pojo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;

/**
 * @author ：hooli
 * @date ：Created in 2020/10/28 3:35 下午
 * @description：
 */
@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    /**
     * @author ：hooli
     * @date ：Created in 2020/10/28 3:36 下午
     * @description：订单减库存，直接调用原生http接口
     */
    @GetMapping("/stock/deduct")
    public Object deductStock(@RequestParam("productId") Long productId, @RequestParam("stockCount") Long stockCount) {

        return this.restTemplate.getForObject("http://localhost:9001/stock/deduct/" + productId + "/" + stockCount, String.class);
    }

    @GetMapping("order/{id}")
    public Object getOrder(HttpServletRequest request, @PathVariable("id") String id) {
        int localPort = request.getLocalPort();
        return new Order(id, "orderName:" + localPort);
    }
}
