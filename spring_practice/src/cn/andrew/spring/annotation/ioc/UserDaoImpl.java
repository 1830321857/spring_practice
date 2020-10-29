package cn.andrew.spring.annotation.ioc;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("userDao")
public class UserDaoImpl implements UserDao{
    private String name;

    /**
     * 使用注解方式设置属性的值，可以没有set方法
     * 如果有set方法，需要将属性注入的注解添加到set方法
     * 如果没有set方法，将注解添加到属性上
     * @param name
     */
    @Value("Andrew")
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void save() {
        System.out.println(name + ",method has been executed...");
    }
}
