package top.jiejie.boot.exception.exception;

import lombok.Getter;
import lombok.Setter;
import top.jiejie.boot.exception.enums.ErrorCode;



/**
 * @Author HHJ
 * @Date: 2024/04/08/ 14:02
 * @description 自定义异常类
 */
@Getter
public class ServerException extends RuntimeException {
    private final int code;
    private final String msg;

    public ServerException(String msg) {
        super(msg);
        this.code = ErrorCode.INTERNAL_SERVER_ERROR.getCode();
        this.msg = msg;

    }

    public ServerException(ErrorCode errorCode) {
        this.code = errorCode.getCode();
        this.msg = errorCode.getMsg();
    }
}
