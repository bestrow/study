package top.anglesang.springbootdemo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TestAspect {

   /* @Pointcut("execution(public * top.anglesang.springbootdemo.controller.*.*(..))")
    public void addAdvice(){

    }*/

    @Pointcut("@annotation(top.anglesang.springbootdemo.Annotation.MyAnnotation)")
    public void addAdvice() {

    }

    @Around("addAdvice()")
    public Object Interceptor(ProceedingJoinPoint pjp) {
        System.out.println("开始执行Interceptor()");
        Object result = null;
        Object[] args = pjp.getArgs();
        if (args != null && args.length > 0) {
            String deviceId = (String) args[0];
            if (!"03".equals(deviceId)) {
                return "no anthorization";
            }
        }
        try {
            result = pjp.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return result;
    }

    @Before("addAdvice()")
    public Object beforeTest() {
        System.out.println("开始执行beforeTest()");
        String result = "在请求开始之前执行。。";
        System.out.println(result);
        return result;
    }
}
