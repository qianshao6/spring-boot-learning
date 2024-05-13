package top.jiejie.boot.fi.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import top.jiejie.boot.fi.interceptor.AuthenticationInterceptor;
import top.jiejie.boot.fi.interceptor.CustomInterceptor;
import top.jiejie.boot.fi.interceptor.LoggingInterceptor;
import top.jiejie.boot.fi.interceptor.PerformanceInterceptor;

@Configuration
@AllArgsConstructor
public class SpringMvcConfig implements WebMvcConfigurer {
    private final CustomInterceptor customInterceptor;
    private final LoggingInterceptor loggingInterceptor;
    private final PerformanceInterceptor performanceInterceptor;
    private  final AuthenticationInterceptor authenticationInterceptor;
    @Bean
    public CorsFilter corsFilter() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        final CorsConfiguration corsConfiguration = new CorsConfiguration
                ();
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.addAllowedHeader("*");
        corsConfiguration.addAllowedOriginPattern("*");
        corsConfiguration.addAllowedMethod("*");
        source.registerCorsConfiguration("/**", corsConfiguration);
        return new CorsFilter(source);
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
       // registry.addInterceptor(customInterceptor);
       // registry.addInterceptor(authenticationInterceptor);
      //  registry.addInterceptor(loggingInterceptor);
        registry.addInterceptor(performanceInterceptor);
    }
}