package com.xbird.web.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import java.util.Date;

//@Aspect
//@Component
public class TimeAspect {

    @Around("execution(* com.xbird.web.controller.UserController.*(..))")
    public Object handlerControllerMethod(ProceedingJoinPoint pjp) throws Throwable  {
        System.out.println("time aspect start");
        Long start = new Date().getTime();
        Object[] args = pjp.getArgs();
        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i]);
        }
        //具体方法的返回值
        Object obj = pjp.proceed();
        System.out.println("time aspect 耗时：" + (new Date().getTime() - start));
        System.out.println("time aspect end");
        return obj;
    }

}
