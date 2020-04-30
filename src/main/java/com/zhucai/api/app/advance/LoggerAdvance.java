package com.zhucai.api.app.advance;/**
 * @Auther:dep
 * @Date: 2020/4/28 16:26
 * @Description:
 */

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.mybatis.logging.Logger;
import org.mybatis.logging.LoggerFactory;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedType;
import java.util.Optional;

/**
 * @Auth: young
 * @Date: 2020-04-28 - 16:26
 * @Description:
 **/
public class LoggerAdvance {

    public Logger logger = LoggerFactory.getLogger(this.getClass());

    public void log(ProceedingJoinPoint proceedingJoinPoint) {
        Class clazz = this.getClass();
        //判断是否包含注解
        AnnotatedType[] annotations= clazz.getAnnotatedInterfaces();
        try {
            proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

}
