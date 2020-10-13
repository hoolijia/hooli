package com.hooli.db.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import java.io.Serializable;

/**   
 * @Description:TODO(API应用KEY实体类)
 * 
 * @version: 1.0.0-SNAPSHOT
 * @author: hooli
 * 
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class User extends Model<User> {

	private static final long serialVersionUID = 1602484136719L;
	
	@TableId(value = "id", type = IdType.AUTO)
	@ApiModelProperty(name = "id" , value = "")
	private Integer id;
    
	@ApiModelProperty(name = "username" , value = "")
	private String username;
    
	@ApiModelProperty(name = "password" , value = "")
	private String password;
    
	@ApiModelProperty(name = "email" , value = "")
	private String email;
    
	@ApiModelProperty(name = "idCard" , value = "")
	@TableField(value = "idCard")
	private String idCard;
    
	@ApiModelProperty(name = "phone" , value = "")
	private String phone;
    

	@Override
    protected Serializable pkVal() {
        return this.id;
    }
}
