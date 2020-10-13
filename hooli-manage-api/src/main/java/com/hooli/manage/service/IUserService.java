package com.hooli.manage.service;

import com.hooli.manage.vo.UserVo;

/**
 * @author ：hooli
 * @date ：Created in 2020/9/15 3:44 下午
 * @description：用户接口
 */
public interface IUserService {

    Object getUserList(UserVo userVo);
}
