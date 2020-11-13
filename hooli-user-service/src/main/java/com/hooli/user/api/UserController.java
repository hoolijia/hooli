package com.hooli.user.api;

import com.hooli.user.pojo.User;
import com.hooli.user.utils.LoadBalance;
import com.hooli.user.utils.RamdomLoadBalance;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author ：hooli
 * @date ：Created in 2020/11/12 4:31 下午
 * @description：
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Resource
    private RestTemplate restTemplate;

    private LoadBalance loadBalance = new RamdomLoadBalance();

    @GetMapping("/user/{id}")
    public Object getUser(HttpServletRequest request, @PathVariable("id") String id) {

        String host = loadBalance.choseServiceHost();
        Object order = restTemplate.getForObject("http://" + host + "/orders/order/1", String.class);

        return new User(id, "hooli", order);
    }
}
