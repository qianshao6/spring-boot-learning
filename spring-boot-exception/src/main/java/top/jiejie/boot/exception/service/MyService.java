package top.jiejie.boot.exception.service;

import lombok.Getter;
import org.springframework.stereotype.Service;
import top.jiejie.boot.exception.enums.ErrorCode;
import top.jiejie.boot.exception.exception.ServerException;
/**
 * @Author HHJ
 * @Date: 2024/04/08/ 14:16
 * @description
 */
@Getter
@Service
public class MyService {
    /*
     * 模拟未登陆异常
     */
    public void unAuthorizedError( ) {
        throw  new ServerException(ErrorCode.UNKNOWN_ERROR);
    }

    /*
     * 模拟系统异常
     */
    public void serverError( ) {
        throw  new ServerException(ErrorCode.INTERNAL_SERVER_ERROR);
    }
}
