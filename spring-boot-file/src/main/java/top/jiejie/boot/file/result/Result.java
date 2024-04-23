package top.jiejie.boot.file.result;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import top.jiejie.boot.file.enums.ErrorCode;

/**
 * @description 统一的接口响应数据结构
 **/
@Data
public class Result<T> {
    private int code = 200;

    private String msg = "登录成功";

    private T data;

    public static <T> Result<T> ok() {
        return ok(null);
    }

    public static <T> Result<T> ok(T data) {
        Result<T> result = new Result<>();
        result.setData(data);
        return result;
    }

    public static <T> Result<T> error() {
        return error(ErrorCode.INTERNSL_SERVER_ERROR);
    }

    public static <T> Result<T> error(String msg) {
        return error(ErrorCode.INTERNSL_SERVER_ERROR.getCode(), msg);
    }

    public static <T> Result<T> error(ErrorCode errorCode) {
        return error(errorCode.getCode(), errorCode.getMsg());
    }

    public static <T> Result<T> error(int code, String msg) {
        Result<T> result = new Result<>();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}