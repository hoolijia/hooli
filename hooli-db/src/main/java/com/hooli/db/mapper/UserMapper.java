package com.hooli.db.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hooli.db.domain.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @version: 1.0.0-SNAPSHOT
 * @author: hooli
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    //IPage<User> selectPageVo(Page<?> page);
}
