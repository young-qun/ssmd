package com.zhucai.api.app.mybatis.method;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlSource;
import org.springframework.stereotype.Component;

/**
 * @Auther:young
 * @Date: 2020/5/15 08:14
 * @Description:
 */
@Component
public class MyAbstractMethod extends AbstractMethod {
    @Override
    public MappedStatement injectMappedStatement(Class<?> mapperClass, Class<?> modelClass, TableInfo tableInfo) {

        String sql  = "delete from " +tableInfo.getTableName();

        String methodName = "deleteAll";

        SqlSource sqlSource = languageDriver.createSqlSource(configuration,sql,modelClass);

        return addDeleteMappedStatement(mapperClass,methodName,sqlSource);
    }
}
