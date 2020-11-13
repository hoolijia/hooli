package com.hooli.user.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ：hooli
 * @date ：Created in 2020/11/12 5:06 下午
 * @description：
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private String id;
    private String username;
    private Object order;
}
