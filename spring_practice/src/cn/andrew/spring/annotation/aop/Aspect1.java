package cn.andrew.spring.annotation.aop;


import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@org.aspectj.lang.annotation.Aspect
public class Aspect1 {

    @Before(value="Aspect1.pointcut()")
    public void before(){
        System.out.println("前置增强");
    }

    @Pointcut(value="execution(public void cn.andrew.spring.annotation.aop.OrderDao.save(..))")
    private void pointcut(){}
}
