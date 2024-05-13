package top.jiejie.boot.cache.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.io.Serial;

/**
 * @description 自定义异常
 **/
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
