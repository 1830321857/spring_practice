package cn.andrew.spring.xml.aop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * AOP的测试类
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class AOPTest {
    @Resource
    private ProductDao productDao;

    @Test
    public void test1(){
        productDao.save();
        productDao.delete();
        productDao.update();
        productDao.find();
    }
}
