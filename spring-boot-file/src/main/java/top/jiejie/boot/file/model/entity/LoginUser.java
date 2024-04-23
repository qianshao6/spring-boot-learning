package top.jiejie.boot.file.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
@TableName("t_login")
public class LoginUser implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("phone")
    private String phone;

    @TableField("password")
    private String password;

    @TableField("nickname")
    private String nickname;

    @TableField("avatar")
    private String avatar;

    @TableField("info")
    private String info;

    @TableField("deleted")
    private String deleted;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private String createTime;

    @TableField(value = "update_time", fill = FieldFill.UPDATE)
    private String updateTime;


}