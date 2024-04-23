package top.jiejie.boot.file.controller;

import io.minio.ObjectWriteResponse;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import top.jiejie.boot.file.utils.MinIoTemplate;
import top.jiejie.boot.file.utils.OssTemplate;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;


@RestController
@RequestMapping(value = "/file")
public class FileUploadController {

    @Value("${file.upload-path}")
    private String uploadPath;

    DateFormat df = new SimpleDateFormat("yyyyMMdd");

    @Resource
    private MinIoTemplate minIoTemplate;


    @Value("${minio.endPoint}")
    private String endPoint;
    @Resource
    private MinIoTemplate minioClient;

    @Resource
    private OssTemplate ossTemplate;


    @PostMapping("/native")
    public String nativeUpload(MultipartFile file,HttpServletRequest request) {
        String today = df.format(new Date());
        //创建上传的子目录
        File folder = new File(uploadPath + "/" + today);
        if (!folder.exists()){
            boolean flag = folder.mkdirs();
            System.out.println(flag);
        }
        //对上传的文件重命名
        String oldFileName = file.getOriginalFilename();
        int index = oldFileName.lastIndexOf(".");
        String suffixName = oldFileName.substring(index+1);
        System.out.println(suffixName);
        String newFileName = UUID.randomUUID() + suffixName;
        //文件上传
        try {
            file.transferTo(new File(folder,newFileName));
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
        //拼接访问地址
        //请求协议 http + "://"

        return request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/" + today + "/" + newFileName;

    }

    //    @PostMapping("/minio")
//    public String minioUpload(MultipartFile file) {
//        ObjectWriteResponse owr;
//        try {
//            owr = minIoTemplate.putObject("ytq", "img/test.jpg", file.getInputStream());
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//        System.out.println(owr.object());
//        //TODO 拼接可访问的图片地址
//        return "success";
//    }
    @PostMapping("/minio")
    public String minioUpload(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws Exception {

        String today = df.format(new Date());
        // 对上传的文件重命名
        String oldFileName = file.getOriginalFilename();
        assert oldFileName != null;
        int index = oldFileName.lastIndexOf(".");
        String suffixName = oldFileName.substring(index);
        System.out.println(suffixName);
        String newFileName = UUID.randomUUID() + suffixName;


        ObjectWriteResponse owr;
        owr = minioClient.putObject("hhj", today + "/" + newFileName, file.getInputStream());
        System.out.println(owr.object());
        return endPoint + "/hhj/" + today + "/" + newFileName;
    }

    /**
     * oss 文件上传
     * @param file 文件对象
     * @return 文件上传后的地址
     */
    @PostMapping("/oss")
    public String ossUpload(MultipartFile file) {
        return ossTemplate.ossUpload(file);
    }
}

