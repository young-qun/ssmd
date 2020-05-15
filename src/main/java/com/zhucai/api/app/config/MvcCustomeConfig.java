package com.zhucai.api.app.config;/**
 * @Auther:dep
 * @Date: 2020/4/29 13:57
 * @Description:
 */

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
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

    //配置逻辑删除的插件 3.1.0 之后的版本不需要配置该sqlInjector 亦可实现
    @Bean
    public ISqlInjector iSqlInjector(){
        return  new LogicSqlInjector();
    }

    //配置 乐观锁实现插件
    public OptimisticLockerInterceptor optimisticLockerInterceptor(){
        return new OptimisticLockerInterceptor();
    }

    @Bean
    public LoggerInterceptor loggerInterceptor(){
        return new LoggerInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loggerInterceptor());
    }
}
