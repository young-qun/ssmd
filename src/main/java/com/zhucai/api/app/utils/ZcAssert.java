package com.zhucai.api.app.utils;/**
 * @Auther:dep
 * @Date: 2020/4/29 14:05
 * @Description:
 */

import org.springframework.util.StringUtils;

import java.util.Collection;
import java.util.Map;

/**
 * @Auth: young
 * @Date: 2020-04-29 - 14:05
 * @Description:
 **/
public class ZcAssert {

    /**
     *@Auth: young
     *@Date: 2020/4/29-14:08
     *@Description: 判空
     *@Param:
     **/
    public static  boolean isEmpty(Object obj){
        if(obj == null){
            return true;
        }
        if(obj instanceof Collection){
            return ((Collection) obj).size()  == 0;
        }
        if(obj instanceof Map){
            return  ((Map) obj).entrySet().size() == 0;
        }
        if( obj instanceof  Object[]){
            return ((Object[]) obj).length == 0;
        }
        if(obj instanceof  String){
            return StringUtils.isEmpty(obj);
        }
        return false;
    }
}
