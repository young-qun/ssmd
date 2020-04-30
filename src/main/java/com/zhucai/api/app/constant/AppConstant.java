package com.zhucai.api.app.constant;/**
 * @Auther:dep
 * @Date: 2020/4/29 09:56
 * @Description:
 */

import sun.reflect.generics.scope.ClassScope;

/**
 * @Auth: young
 * @Date: 2020-04-28 - 9:56
 * @Description: APP 使用的常量
 **/
public class AppConstant  {
    /***
     * mybatis的方法前缀
     */
    public  static class MetodTypePrefix{

        /***
         * 插入
         */
        public  static  final  String INSERT = "insert";

        public  static  final  String CREATE = "create";

        /***
         * 更新
         */
        public  static  final String UPDATE = "update";

        /***
         * 删除
         */
        public static  final String DELETE = "delete";

    }
}
