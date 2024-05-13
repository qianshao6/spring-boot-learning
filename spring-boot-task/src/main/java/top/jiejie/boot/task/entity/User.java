package top.jiejie.boot.task.entity;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@TableName("user")
@EqualsAndHashCode
public class User implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    @ExcelProperty("用户id")
    private Integer id;

    @TableField("username")
    @ExcelProperty("用户姓名")
    private String username;

    @TableField("phone")
    @ExcelProperty("用户手机号")
    private String phone;

    @TableField("gender")
    @ExcelProperty("性别")
    private String gender;

    @TableField("create_time")
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

    @TableField("update_time")
    @ExcelProperty("修改时间")
    private LocalDateTime updateTime;

    @TableField("deleted")
    @ExcelProperty("删除标志")
    private Integer deleted;

}
