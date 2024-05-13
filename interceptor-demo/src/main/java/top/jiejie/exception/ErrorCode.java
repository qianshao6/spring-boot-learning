package top.jiejie.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @program: share-app-api
 * @description:
 * @author: HHJ
 * @create: 2024-04-28 14:22
 **/
@Getter
@AllArgsConstructor
public enum ErrorCode {
    UNAUTHORIZED(401, "还未授权，不能访问"),
    FORBIDDEN(403, "没有权限，禁⽌访问"),
    INTERNAL_SERVER_ERROR(500, "服务器异常，请稍后再试"),
    LOGIN_ERROR(301, "登录失败");
    private final int code;
    private final String msg;
}
