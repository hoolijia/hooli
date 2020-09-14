package com.hooli.manage.api;

import com.hooli.manage.service.IScoreService;
import com.hooli.manage.vo.UserVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "用户接口")
@RestController
@RequestMapping("test")
@Slf4j
public class UserController {

    @Autowired
    private IScoreService iScoreService;

    @ApiOperation("获取用户信息")
    @GetMapping("/user")
    public UserVo getUser() {
        log.info("--------- get user info ---------");
        UserVo userVo = new UserVo();
        userVo.setId(1);
        userVo.setUsername("hooli");
        userVo.setPassword("123456");
        return userVo;
    }

    @ApiOperation("注册用户")
    @PostMapping("/user")
    public String registerUser() {
        log.info("----------- 注册用户 -------------");
        //this.iScoreService.addScore();
        this.iScoreService.addScore2();

        return "注册成功";
    }
}
