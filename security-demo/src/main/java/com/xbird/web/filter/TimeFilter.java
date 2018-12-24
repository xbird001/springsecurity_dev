package com.xbird.web.filter;

import javax.servlet.*;
import java.io.IOException;
import java.util.Date;

/**
 * 耗时计算拦截器
 */
/*@Component*//* 可以通过compent注解的方式直接进行注册，但是无法配置拦截的URL，默认拦截所有请求 */
public class TimeFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("time filter init.");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("time filter begin");
        Long start = new Date().getTime();
        chain.doFilter(request,response);
        System.out.println("time filter 耗时:" + (new Date().getTime()-start));
    }

    @Override
    public void destroy() {

    }
}
