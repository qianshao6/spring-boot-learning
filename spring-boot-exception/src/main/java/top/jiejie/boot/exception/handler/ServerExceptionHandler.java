package top.jiejie.boot.exception.handler;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import top.jiejie.boot.exception.exception.ServerException;
import top.jiejie.boot.exception.result.Result;


/**
 * @Author HHJ
 * @Date: 2024/04/08/ 14:19
 * @description
 */
@Slf4j
@RestControllerAdvice
public class ServerExceptionHandler {

    /**
     * 处理自定义异常
     * @param e 异常对象
     * @return Result
     */
    @ExceptionHandler(value = ServerException.class)
    public Result<?> handleServerException(ServerException e) {
        return Result.error(e.getCode(), e.getMsg());
    }

    /**
     * 处理空指针异常
     * @param e 异常对象
     * @return Result
     */
    @ExceptionHandler(value = Exception.class)
    public Result<?> handleNullPointerException(Exception e) {
        return Result.error(e.getMessage());
    }

}