package top.jiejie.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import top.jiejie.constant.Constant;
import top.jiejie.interceptor.AuthInterceptor;
import top.jiejie.interceptor.UploadInterceptor;

/**
 * @program: spring-boot-learning
 * @description:
 * @author: hhj
 * @create: 2024-05-06 00:37
 **/
@Configuration
@AllArgsConstructor
public class SpringMvcConfig implements WebMvcConfigurer {
    private final AuthInterceptor authInterceptor;
    private final UploadInterceptor uploadInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry
                .addInterceptor(authInterceptor)
                .addPathPatterns(Constant.AUTH_LOGOUT, Constant.AUTH_INFO);

        registry
                .addInterceptor(uploadInterceptor)
                .addPathPatterns(Constant.AUTH_UPLOAD);
    }
}