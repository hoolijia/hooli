package com.hooli.db;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hooli.db.domain.User;
import com.hooli.db.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author ：hooli
 * @date ：Created in 2020/10/12 2:56 下午
 * @description：mybatis-plus-test
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SampleTest {

    @Resource
    private UserMapper userMapper;

    @Test
    public void testSelect() {

        System.out.println(("------- selectAll method test ----------"));
        List<User> userList = userMapper.selectList(null);
        Assert.assertEquals(11, userList.size());
        userList.forEach(System.out::println);
    }

    /**
     * @author     ：hooli
     * @date       ：Created in 2020/10/12 4:59 下午
     * @description：自带分页
     */
    @Test
    public void testPage() {

        log.error("----------------------------------baseMapper 自带分页-------------------------------------------------------");
        Page<User> page = new Page<>(1, 10);
        Page<User> userPage = userMapper.selectPage(page, null);
        assertThat(page).isSameAs(userPage);
        log.error("总条数 -------------> {}", userPage.getTotal());
        log.error("当前页数 -------------> {}", userPage.getCurrent());
        log.error("当前每页显示数 -------------> {}", userPage.getSize());
        log.error("222 ----------> {}", userPage.getPages());
        List<User> records = userPage.getRecords();
        records.forEach(System.out::println);
    }
}
