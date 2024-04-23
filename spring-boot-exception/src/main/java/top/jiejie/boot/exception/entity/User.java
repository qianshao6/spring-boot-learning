package top.jiejie.boot.exception.entity;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import top.jiejie.boot.exception.annotation.Phone;
import top.jiejie.boot.exception.annotation.Sfz;


/**
 * @Author HHJ
 * @Date: 2024/04/08/ 14:42
 * @description
 */
@Data
public class User {
    @NotBlank(message = "用户名不能为空")
    private String username;

    @NotBlank(message = "密码不能为空")
    private String password;

    @Max(value = 100, message = "年龄不能大于100")
    @Min(value = 10, message = "年龄不能小于10")
    private int age;

    @Phone(message = "你的手机号码不对")
    private String phone;

    @Sfz(message = "你的身份证号码不对")
    private String Sfz;

}
