package com.hooli.credit.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：hooli
 * @date ：Created in 2020/12/17 12:57 下午
 * @description：积分Controller
 */
@RestController
@RequestMapping("credit")
public class CreditController {

    @PostMapping("add")
    public Object addCredit(Long userId, Integer creditCount) {

        return "success";
    }
}
