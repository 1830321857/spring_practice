package cn.andrew.spring.xml.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 切面类
 */
public class Aspect {
    /**
     * 前置通知
     * @param joinPoint
     */
    public void checkPrivilege(JoinPoint joinPoint){
        //JoinPoint是切入点的信息
        System.out.println("checking your privilege===============" + joinPoint);
    }

    /**
     * 后置通知
     */
    public void writeLog( Object productName){
        System.out.println("writing log===============" + productName + "已删除");
    }

    /**
     * 环绕通知
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    public Object monitorPerformance(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("start monitor Performance！");
        Object obj= joinPoint.proceed();
        System.out.println("finish monitor");
        return obj;
    }

    /**
     * 异常抛出通知
     */
    public void afterException(Throwable exception){
        System.out.println("after throw exception=================" + exception.getMessage());
    }
}
