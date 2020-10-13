package com.hooli.db.model;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author ：hooli
 * @date ：Created in 2020/10/12 4:48 下午
 * @description：自定义返回
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class MyPage<T> extends Page<T> {

    private static final long serialVersionUID = 5194933845448697148L;

    public MyPage(long current, long size) {
        super(current, size);
    }

    private Integer selectInt;
    private String selectStr;
    private String name;
}
