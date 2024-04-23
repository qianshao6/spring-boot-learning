package top.jiejie.boot.exception.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;


/**
 * @Author HHJ
 * @Date: 2024/04/08/ 13:53
 * @description
 */
@Getter
@AllArgsConstructor
public enum ErrorCode {

    UNAUTHORIZED(401, "登陆失效，请重新登录"),
    INTERNAL_SERVER_ERROR(500, "服务器异常请稍后再试"),
    UNKNOWN_ERROR(999, "未知错误");



    private final int code;

    private final String msg;



}
