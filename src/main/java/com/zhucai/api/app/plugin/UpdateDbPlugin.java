package com.zhucai.api.app.plugin;

import com.zhucai.api.app.constant.AppConstant;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.executor.SimpleExecutor;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @Auth: young
 * @Date: 2020-04-29 - 9:44
 * @Description: 拦截所有的insert和update操作，更新modifytime version
 **/
@Intercepts(
        @Signature(type = SimpleExecutor.class,method ="update",args =java.sql.Statement.class ))
public class UpdateDbPlugin implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        Object target = invocation.getTarget();
            Method method  = invocation.getMethod();
            //判断方法名是否为insert 、update 、delete 开始
            String methodName = method.getName();
            if(methodName.toLowerCase().startsWith(AppConstant.MetodTypePrefix.CREATE)
                    || methodName.toLowerCase().startsWith(AppConstant.MetodTypePrefix.INSERT)){
                Field createTime = target.getClass().getField("createTime");
                createTime.setLong(createTime,System.currentTimeMillis());
            }
            if(methodName.toLowerCase().startsWith(AppConstant.MetodTypePrefix.UPDATE)
                    || methodName.toLowerCase().startsWith(AppConstant.MetodTypePrefix.DELETE)){
                Field modifyTime = target.getClass().getField("modifyTime");
                modifyTime.setLong(modifyTime,System.currentTimeMillis());
                Field version = target.getClass().getField("version");
                modifyTime.setInt(version,version.getInt("version")+1);

        }
        //方法执行
        invocation.proceed();
        return null;
    }

    @Override
    public Object plugin(Object target) {
        return null;
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
