package com.zhucai.api.app.mybatis.method;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.injector.DefaultSqlInjector;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther:young
 * @Date: 2020/5/15 08:23
 * @Description:
 */
@Component
public class MysqlInjector extends DefaultSqlInjector {

    @Override
    public List<AbstractMethod> getMethodList(Class<?> mapperClass) {
        List<AbstractMethod> methods = new ArrayList<>();
        methods.addAll(super.getMethodList(mapperClass));
        MyAbstractMethod myAbstractMethod = new MyAbstractMethod();
        methods.add(myAbstractMethod);
        return methods;
    }
}
