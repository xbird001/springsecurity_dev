package com.xbird.web.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@Component
public class TimeInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("time interceptor before");
        System.out.println("拦截器类：" + ((HandlerMethod)handler).getBean().getClass().getName());
        System.out.println("拦截器方法：" + ((HandlerMethod)handler).getMethod().getName());
        Long start = new Date().getTime();
        request.setAttribute("startTime",start);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("time interceptor post");
        Long startTime = (Long) request.getAttribute("startTime");
        System.out.println("TimeInterceptor 耗时：" + (new Date().getTime() - startTime));
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("exist or not exist exception");
        Long startTime = (Long) request.getAttribute("startTime");
        System.out.println("TimeInterceptor 耗时：" + (new Date().getTime() - startTime));
    }
}
