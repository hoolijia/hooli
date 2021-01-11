package com.hooli.manage.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hooli.core.utils.ResponseUtil;
import com.hooli.db.domain.User;
import com.hooli.db.mapper.UserMapper;
import com.hooli.manage.service.IUserService;
import com.hooli.manage.vo.UserVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author ：hooli
 * @date ：Created in 2020/9/15 3:44 下午
 * @description：用户接口实现
 */
@Service
@Slf4j
public class IUserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public Object getUserList(UserVo userVo) {

        Page<User> page = new Page<>(userVo.getPageNum(), userVo.getPageSize());

        return ResponseUtil.okList(userMapper.selectPage(page, null));
    }

}
