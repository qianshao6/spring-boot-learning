package top.jiejie.boot.file.exception;
import lombok.Data;
import lombok.EqualsAndHashCode;
import top.jiejie.boot.file.enums.ErrorCode;

import java.io.Serial;

/**
 * @description 自定义异常
 **/
@Data
@EqualsAndHashCode(callSuper = true)
public class ServerException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    private int code;
    private String msg;

    public ServerException(String msg) {
        super(msg);
        this.code = ErrorCode.INTERNSL_SERVER_ERROR.getCode();
        this.msg = msg;
    }

    public ServerException(ErrorCode errorCode) {
        super(errorCode.getMsg());
        this.code = errorCode.getCode();
        this.msg = errorCode.getMsg();
    }

    public ServerException(String msg, Throwable e) {
        super(msg, e);
        this.code = ErrorCode.INTERNSL_SERVER_ERROR.getCode();
        this.msg = msg;
    }
}
