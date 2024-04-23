package top.jiejie.boot.file;

import cn.hutool.crypto.digest.DigestUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
@MapperScan(basePackages = {"top.jiejie.boot.file.mapper"})
public class FileApplication {
    public static void main(String[] args) {
        SpringApplication.run(FileApplication.class, args);
        System.out.println(DigestUtil.md5Hex("123123"));
    }

}
