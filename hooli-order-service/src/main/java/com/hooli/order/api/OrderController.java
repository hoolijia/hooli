package com.hooli.order.api;

import com.hooli.order.pojo.Order;
import com.hooli.order.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
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

    @Autowired
    private IOrderService orderService;

    /**
     * @author ：hooli
     * @date ：Created in 2020/12/16 3:26 下午
     * @description： 减库存，使用RestTemplate调用远程接口
     */
    @PostMapping(value = "/stock/deduct")
    public Object deductStock(Long productId, Integer stockCount) {
        MultiValueMap<String, Object> reqMap = new LinkedMultiValueMap<>();
        reqMap.add("productId", productId);
        reqMap.add("stockCount", stockCount);

        String url = "http://hooli-stock-service/stock/deduct/";

        //return this.restTemplate.getForObject("http://hooli-stock-service/stock/deduct/", String.class, reqMap);
        return this.restTemplate.postForObject(url, reqMap, String.class);
    }

    @GetMapping("order/{id}")
    public Object getOrder(HttpServletRequest request, @PathVariable("id") String id) {
        int localPort = request.getLocalPort ();
        return new Order(id, "orderName:" + localPort);
    }

    @PostMapping("/create")
    public Object createOrder(
            Long productId,
            Long userId,
            Integer stockCount,
            Integer creditCount) {

        return orderService.createOrder(productId, userId, stockCount, creditCount);
    }
}
