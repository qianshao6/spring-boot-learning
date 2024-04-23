package top.jiejie.boot.file.utils;

import io.minio.ObjectWriteResponse;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileInputStream;

@SpringBootTest
class MinIoTemplateTest {

@Resource
private MinIoTemplate minIoTemplate;

    @Test
    void bucketExists() throws Exception {
        boolean flag= minIoTemplate.bucketExists("hhj");
        System.out.println(flag);
    }

    @Test
    void makeBucket() throws Exception{
        minIoTemplate.makeBucket("hhj");
    }

    @Test
    void putObject() throws Exception {
        File file=new File("C:/Users/13400/Desktop/H/1.jpg");
        //TODO 上传文件用UUID
        ObjectWriteResponse owr=minIoTemplate.putObject("hhj","img/test.jpg",new FileInputStream(file));
        System.out.println("http://43.137.12.232:9000/hhj/"+owr.object());
    }
}