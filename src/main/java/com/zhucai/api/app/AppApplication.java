package com.zhucai.api.app;

import com.alibaba.druid.pool.DruidDataSource;
import com.sun.org.glassfish.gmbal.NameValue;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.DispatcherServlet;

import javax.sql.DataSource;
import java.sql.Driver;

@SpringBootApplication
public class AppApplication {

	@Bean("dispatcherServletRegistrationBean")
	public ServletRegistrationBean servletRegistrationBean(DispatcherServlet dispatcherServlet){
		ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(dispatcherServlet, "/app/*");
		servletRegistrationBean.setLoadOnStartup(0);
		servletRegistrationBean.setName("app");
		return servletRegistrationBean;
	}

	@Bean
	public MultipartResolver getMultipartResolver(){
		MultipartResolver multipartResolver = new CommonsMultipartResolver();
		return multipartResolver;
	}



	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}

}
