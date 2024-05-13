package top.jiejie.config;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
 * @program: spring-boot-learning
 * @description:
 * @author: HHJ
 * @create: 2024-05-06 00:37
 **/
@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("拦截器测试 API")
                        .contact(new Contact().name("ytq").email("3361345583@qq.com"))
                        .version("1.0")
                        .description("Knife4j 集成 springdoc-openapi 示例")
                        .termsOfService("http://doc.xiaominfo.com")
                        .license(new License().name("Apache 2.0")
                                .url("http://doc.xiaominfo.com")));
    }
}