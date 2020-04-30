package com.zhucai.api.app.interceptor;

import org.slf4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Auth: young
 * @Date: 2020-04-29 - 10:37
 * @Description: 记录方法的请求的信息
 **/
public class LoggerInterceptor  implements HandlerInterceptor{
    public  Logger logger  = org.slf4j.LoggerFactory.getLogger(this.getClass());
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        StringBuilder sb = new StringBuilder("请求的路径：");
        String url  = request.getRequestURI();
        sb.append(url);
        sb.append("--参数：params ");
        while (request.getHeaderNames().hasMoreElements()){
            sb.append(request.getHeaderNames().nextElement()).append(",");
        }
        logger.debug(sb.append("----开始时间：").append(System.currentTimeMillis()).toString());
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        StringBuilder sb = new StringBuilder("请求的路径：");
        String url  = request.getRequestURI();
        sb.append(url);
        logger.debug(sb.append("----结束时间：").append(System.currentTimeMillis()).toString());
    }

}
