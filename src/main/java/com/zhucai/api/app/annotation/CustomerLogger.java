package com.zhucai.api.app.annotation;

import java.lang.annotation.*;

/**
 * @Auther:dep
 * @Date: 2020/4/29 13:46
 * @Description:
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface CustomerLogger {
    String name();
    int type() default  0;
    String params() default "";
}
