package cn.andrew.spring.annotation.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao user = (UserDao) applicationContext.getBean("userDao");
        user.save();
    }
}
