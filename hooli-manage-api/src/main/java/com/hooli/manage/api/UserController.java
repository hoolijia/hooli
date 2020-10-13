package com.hooli.manage.api;

import com.hooli.core.enums.ResultCode;
import com.hooli.core.exceptions.BusinessException;
import com.hooli.core.utils.ResponseUtil;
import com.hooli.manage.service.IScoreService;
import com.hooli.manage.service.IUserService;
import com.hooli.manage.vo.UserVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Api(tags = "用户接口")
@RestController
@RequestMapping("test")
@Slf4j
public class UserController {

    @Autowired
    private IScoreService iScoreService;

    @Autowired
    private IUserService iUserService;

    @ApiOperation("分页")
    @PostMapping("/list")
    public Object getUserList(@RequestBody UserVo userVo) {

        log.info("------------- get userList ---------------");

        return iUserService.getUserList(userVo);
    }

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
    @PostMapping("/register")
    public String registerUser(@RequestBody @Validated UserVo userVo) {
        log.info("----------- 注册用户 -------------");

        // 使用假线程池
        //this.iScoreService.addScore();

        // 使用线程池
        this.iScoreService.addScore2();

        return "注册成功";
    }

    @PostMapping("/update")
    public void updateUser(@RequestBody @Validated UserVo userVo) {

        UserVo user = null;
        Assert.notNull(user, "用户不存在！");
    }

    @PostMapping("/testUser")
    public void testUser() {
        System.out.println("testUser");
    }

    @ApiOperation("全局异常")
    @PostMapping("/error1")
    public void error1() {
        int i = 9 / 0;
    }

    @ApiOperation("自定义异常")
    @PostMapping("/error2")
    public void error2() {
        throw new BusinessException(ResultCode.ERROR_USER_HAS_EXISTED);
    }
}
