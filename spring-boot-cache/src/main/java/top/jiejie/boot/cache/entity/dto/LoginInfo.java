package top.jiejie.boot.cache.entity.dto;

import lombok.Builder;
import lombok.Data;

/**
 * @Author HHJ
 * @Date: 2024/04/22/ 下午9:36
 * @description
 */
//dto
//用于接收前端传来的登录信息

@Data
@Builder
public class LoginInfo {
    String phoneNumber;
    String verificationCode;
}
