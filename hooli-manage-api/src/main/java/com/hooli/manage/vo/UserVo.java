package com.hooli.manage.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value = "用户信息")
@Data
public class UserVo {

    @ApiModelProperty(value = "用户ID")
    private Integer id;
    private String username;
    private String password;
}
