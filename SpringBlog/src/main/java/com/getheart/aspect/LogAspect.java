package com.getheart.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author Json
 * @date 2020-30-20:23
 */
@Aspect
@Component
public class LogAspect {

   /* @Pointcut("execution(* com.getheart.controller.*.*(..))")
    public void pt() {

    }

    //@Before("pt()")
    public void beforeprintlog() {
        System.out.println("前置通知Logger类中的printlog开始执行了");
    }

    //@AfterReturning("pt()")
    public void afterReturningprintlog() {
        System.out.println("后置通知Logger类中的printlog开始执行了");
    }

    //@AfterThrowing("pt()")
    public void afterThrowingprintlog() {
        System.out.println("异常通知Logger类中的printlog开始执行了");
    }

    //@After("pt()")
    public void afterprintlog() {
        System.out.println("最终通知Logger类中的printlog开始执行了");
    }
*/

}
