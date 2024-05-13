package top.jiejie.boot.fi.result;

import lombok.Getter;
import lombok.Setter;
import top.jiejie.boot.fi.enums.ErrorCode;

@Getter
@Setter
public class Result<T> {
    private int code = 0;
    private String msg = "success";
    private T data;

    public static <T> Result<T> ok(){
        return new Result<>();
    }
    public static <T> Result<T> ok(T data){
        Result<T> rs = new Result<>();
        rs.setData(data);
        return  rs;
    }
    public static <T> Result<T> error(){
        Result<T> rs = new Result<>();
        rs.setMsg(ErrorCode.INTERNAL_SERVER_ERROR.getMsg());
        return  rs;
    }

    public static <T> Result<T> error(String msg){
        Result<T> rs = new Result<>();
        rs.setMsg(msg);
        return  rs;
    }

    public static <T> Result<T> error(int code,String msg){
        Result<T> rs = new Result<>();
        rs.setCode(code);
        rs.setMsg(msg);
        return  rs;
    }

}
