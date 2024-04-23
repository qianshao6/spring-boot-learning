package top.jiejie.boot.file.utils;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import top.jiejie.boot.file.config.OssConfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;


/**
 * @author HHJ
 * @description OssTemplate
 **/
@Component
public class OssTemplate {
    @Resource
    private OssConfig ossConfig;

    /**
     * 上传文件
     *
     * @param file 文件参数
     * @return 上传后的 url
     */

    public String ossUpload(MultipartFile file) {
        String endpoint = ossConfig.getEndpoint();
        String bucket = ossConfig.getBucket();
        String dir = ossConfig.getDir();
        String host = ossConfig.getHost();
        String ak = ossConfig.getAk();
        String secret = ossConfig.getSecret();

        // 创建 OSSClient 实例
        OSS ossClient = new OSSClientBuilder().build(endpoint, ak, secret);
        // 上传文件存放的路径
        String originalFilename = file.getOriginalFilename();
        assert originalFilename != null;
        String suffixName = originalFilename.substring(originalFilename.lastIndexOf("."));
        String uploadPath = dir + UUID.randomUUID() + suffixName;
        // 获取文件的字节输入流
        InputStream inputStream;
        try {
            inputStream = file.getInputStream();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // 调用 SDK 上传文件
        ossClient.putObject(bucket, uploadPath, inputStream);
        // 关闭 ossClient
        ossClient.shutdown();
        // 返回上传文件的 url
        return host + "/" + uploadPath;
    }

}