package cn.andrew.spring.annotation.aop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * 基于注解的AOP的测试类
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class AOPTest {

    @Resource(name = "OrderDao")
    private OrderDao orderDao;

    @Test
    public void test(){
        orderDao.save();
    }
}
