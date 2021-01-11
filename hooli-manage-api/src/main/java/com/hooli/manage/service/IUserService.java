package com.hooli.manage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hooli.db.domain.User;
import com.hooli.manage.vo.UserVo;

/**
 * @author ：hooli
 * @date ：Created in 2020/9/15 3:44 下午
 * @description：用户接口
 */
public interface IUserService extends IService<User> {

    Object getUserList(UserVo userVo);
}
