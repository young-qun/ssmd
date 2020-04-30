package com.zhucai.api.app.config;/**
 * @Auther:dep
 * @Date: 2020/4/29 13:57
 * @Description:
 */

import com.zhucai.api.app.interceptor.LoggerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Auth: young
 * @Date: 2020-04-28 - 13:57
 * @Description:
 **/
@Configuration
public class MvcCustomeConfig  implements WebMvcConfigurer {

    @Bean
    public LoggerInterceptor loggerInterceptor(){
        return new LoggerInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loggerInterceptor());
    }
}
