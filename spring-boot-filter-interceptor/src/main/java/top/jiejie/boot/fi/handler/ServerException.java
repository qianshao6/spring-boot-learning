package top.jiejie.boot.fi.handler;

import lombok.Data;
import lombok.EqualsAndHashCode;
import top.jiejie.boot.fi.enums.ErrorCode;


@EqualsAndHashCode(callSuper = true)
@Data
public class ServerException extends RuntimeException{
    private final int code;
    private final String msg;

    public ServerException(String msg){
        super(msg);
        this.code = ErrorCode.INTERNAL_SERVER_ERROR.getCode();
        this.msg = msg;
    }

    public ServerException(ErrorCode code){
        this.code = code.getCode();
        this.msg = code.getMsg();
    }
}