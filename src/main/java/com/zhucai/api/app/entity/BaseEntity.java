package com.zhucai.api.app.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

/**
 * @Auth: young
 * @Date: 2020-04-28 - 17:37
 * @Description:
 **/
@Getter
@Setter
public class BaseEntity {

    @TableId(type = IdType.AUTO)
    private  Long id;

    @TableField(exist = true)
    private Long createUser;

    @TableField(exist = true)
    private Long createTime;

    @TableField(exist = true)
    private Long modifyUser;

    @TableField(exist = true)
    private Long modifyTime;

    @TableLogic(value = "1",delval = "3")
    @TableField(exist = true,el = "default value 1")
    private Integer status;


    @Version
    @TableField(exist = true,fill = FieldFill.INSERT_UPDATE,el = "default value 0")
    private Integer version;

}
