package top.jiejie.boot.task.utils;

import com.alibaba.excel.EasyExcel;
import top.jiejie.boot.task.entity.User;

import java.util.List;

public class ExcelUtil {

    // 这个方法负责把用户数据写入到指定的Excel文件中
    public static void writeExcel(String fileName, List<User> data) {
        EasyExcel.write(fileName, User.class).sheet("用户数据").doWrite(data);
    }
}