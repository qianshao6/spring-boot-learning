package top.jiejie.interceptor;

import cn.hutool.core.img.ImgUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.extra.qrcode.QrCodeUtil;
import cn.hutool.json.JSONObject;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import top.jiejie.boot.fi.utils.JwtUtil;
import top.jiejie.constant.Constant;
import top.jiejie.exception.ErrorCode;
import top.jiejie.exception.ServerException;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

/**
 * @program: spring-boot-learning
 * @description:
 * @author: ytq
 * @create: 2024-05-06 00:40
 **/
@Slf4j
@AllArgsConstructor
@Component
public class UploadInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("进⼊图⽚上传拦截器！！");
        String accessToken = JwtUtil.getAccessToken(request);
        if (StringUtils.isBlank(accessToken)) {
            throw new ServerException(ErrorCode.UNAUTHORIZED);
        }
        if (!JwtUtil.validate(accessToken)) {
            throw new ServerException(ErrorCode.UNAUTHORIZED);
        }
        // 取出JWT中的载荷：id和昵称
        JSONObject payload = JwtUtil.getPayload(accessToken);
        Object userId = payload.get(Constant.USER_ID);
        Object nickname = payload.get(Constant.NICKNAME);
        // 取出file
        MultipartFile file = ((MultipartHttpServletRequest) request).getFile("file");
        if (file != null) {
            // 添加⽔印
            MultipartFile watermarkedFile = addWatermark(file, userId + " , " + nickname);
                    // 将加了⽔印的⽂件重新放⼊request中，传给接⼝
                    request.setAttribute("watermarkedFile", watermarkedFile);
        }
        return true;
    }
    private MultipartFile addWatermark(MultipartFile file, String text) throws IOException {
        String fileName = file.getOriginalFilename();
        if (StringUtils.isNotBlank(fileName)) {
            // uuid 前缀
            String prefix = UUID.randomUUID().toString().replace("-", "");
            // ⽂件后缀名
            String suffix = fileName.substring(fileName.lastIndexOf("."));
            // 创建临时⽂件
            File tempFile = File.createTempFile(prefix, suffix);
            // 获取图⽚⼤⼩，⽤来计算⽔印位置
            BufferedImage image = ImageIO.read(file.getInputStream());
            int width = image.getWidth();
            int height = image.getHeight();
            log.info("width:{},height:{}", width, height);
            // 复制到临时⽂件
            file.transferTo(tempFile);
            // ⽬标⽂件路径
            String filePath = Constant.TEMP_PATH + "/" + prefix + suffix;
            // 临时⽂件加指定内容和格式的⽔印，⽣成到⽬标⽂件
            ImgUtil.pressText(FileUtil.file(tempFile), FileUtil.file(filePath), text, Color.WHITE, new Font("⿊体", Font.BOLD, 80), width / 3, height / 3, 1.0f);
            // 将带了⽔印的⽬标⽂件包装为 MockMultipartFile
            return new MockMultipartFile("file", fileName, "image/jpeg", Files.readAllBytes(Paths.get(filePath)));
        }
        throw new ServerException(ErrorCode.INTERNAL_SERVER_ERROR);
    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse
            response, Object handler, ModelAndView modelAndView) throws Exception {
        String url = (String) request.getAttribute("url");
        log.info("url:{}", url);
        QrCodeUtil.generate(url, 300, 300, FileUtil.file(Constant.TEMP_PATH + "/" + UUID.randomUUID() + ".png"));
    }
}