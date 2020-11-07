# spring_practice
用于学习Spring框架的项目

## Spring的IOC的注解开发

### 1.创建项目，引入Spring框架需要的jar包

### 2.创建Spring的配置文件

1. 创建applicationContext.xml文件，该文件是Spring框架的配置文件

2. 在配置文件中引入约束（Spring 5版本的约束在spring-framework-5.1.8.RELEASE/docs/spring-framework-reference/core.html页面中）



### Spring的IOC的注解详解

#### @Component

功能：修饰类，将这个类交给Spring管理

该注解有三个衍生注解（功能类似）：

- @Controller：修饰web层的类
- @Service：修饰service层的类
- @Repository：修饰dao层的类

#### @Value

功能：属性注入的注解，用于注入普通属性的值

#### @Autowired

功能：属性注入的注解，用于注入对象类型的值

@Autowired注解按照类型完成属性注入，如果想按照名称注入，需要和@Qualifier注解一起使用

#### @Resource

功能：属性注入的注解，用于完成对象类型属性的注入，功能上相当于@Autowired和@Qualifier一起使用

**该注解不是Spring的注解，是Spring实现的规范中的注解**

#### @PostConstruct

功能：生命周期相关的注解，用于注解初始化方法

#### @PreDestroy

功能：生命周期相关的注解，用于注解销毁方法

#### @Scope

功能：Bean作用范围的注解

- singleton
- prototype
- request
- session
- globalsession

## IOC的XML和注解的比较

### 适用场景

- XML方式：使用于任何场景
- 注解方式：在某些场景下无法使用，例如：当使用的类无法修改时无法使用注解的方式进行开发

### 优缺点

#### XML方式

优点：结构清晰、维护方便，通过xml配置文件可以清楚的知道类的调用和属性的注入方式，并且方便修改

缺点：开发过程相较注解的方式复杂

#### 注解方式

优点：开发方便，省去了编辑配置文件的过程

缺点：修改起来较为复杂，且结构不够清晰

## Spring的AOP的xml开发

### 什么是AOP？

AOP是面向切面编程，是OOP的扩展和延伸，解决OOP开发遇到的问题。

AOP的优点：在不修改源码的情况下对程序进行增强

用途：可以进行权限校验，日志记录、性能监控和事务控制。

### Spring底层对AOP实现原理

动态代理

- JDK动态代理：只能对实现了接口的类产生代理
- Cglib动态代理（类似于Javassist，都是第三方代理技术）：对没有实现接口的类产生代理对象，生成子类对象

### AOP的相关术语

- Joinpoint：连接点，所谓连接点是指哪些被拦截到的点。在spring中，这些点指的是方法，因为spring只支持方法类型的连接点。
- Pointcut：切入点，所谓切入点是指我们要对哪些Joinpoint进行拦截的定义
- Advice：通知/增强，所谓通知是指拦截到Joinpoint之后所要做的事情就是通知，通知分为前置通知、后置通知、异常通知、最终通知、环绕通知
- Introduction：引介，引介是一种特殊的通知。在不修改类代码的前提下，Introduction可以在运行期为类动态地添加一些方法或Field（相当于类层面的增强）
- Target：目标对象，代理的目标对象
- Weaving：织入，是指增强应用到目标对象来创建新的代理对象的过程。spring采用动态代理织入，而AspectJ采用编译期织入和类装载期织入
- Proxy：代理，一个类被AOP织入增强后，就产生一个结果代理类
- Aspect：切面，是切入点和通知（引介）的结合

### AOP入门（AspectJ的XML的方式）

#### 1.创建Web项目，引入jar包

需要引入两部分的jar包：

- Spring框架的基本开发包
- AOP开发的相关jar包

#### 2.创建配置文件

引入AOP的约束

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xmlns:aop="http://www.springframework.org/schema/aop" 
    xsi:schemaLocation="
        http://www.springframework.org/schema/beans          
        https://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/aop 
        https://www.springframework.org/schema/aop/spring-aop.xsd">

    <!-- bean definitions here -->
</beans>
```

#### 3.编写目标类并完成位置

#### 4.Junit与Spring的整合

引入Spring框架中的spring-test-5.1.8.RELEASE.jar

使用下面的代码进行测试：

```java
@RunWith(SpringJUnit4ClassRunner.class)  //固定写法
@ContextConfiguration("classpath:applicationContext.xml")  //配置文件
public class AOPTest {
    @Resource
    private ProductDao productDao;

    @Test
    public void test1(){
        productDao.save();
    }
}
```

#### 5.编写一个切面类

1. 编写一个切面类
2. 将切面类交给Spring

#### 6.通过AOP的配置实现

```java
<!--通过AOP的配置完成对目标类的代理-->
    <aop:config>
        <!--表达式配置那些类的哪些方法需要增强-->
        <aop:pointcut id="pointCut1" expression="execution(* cn.andrew.spring.xml.aop.ProductDaoImpl.save(..))"/>

        <!--配置切面-->
        <aop:aspect ref="Aspect">
            <aop:before method="checkPrivilege" pointcut-ref="pointCut1"/>
        </aop:aspect>
    </aop:config>
```

### AOP中的通知类型

#### 前置通知：在目标方法执行之前进行操作

- 可以获得切入点的信息

#### 后置通知：在目标方法执行之后进行操作

- 可以获得切入点的信息
- 可以获得方法的返回值

#### 环绕通知：在目标方法执行之前和之后进行操作

环绕通知可以阻止目标方法的执行

#### 异常抛出通知：在程序出现异常的时候进行的操作

#### 最终通知：无论代码是否有异常，总是会执行

#### 引介通知：不会用

### AOP的切入点表达式写法

#### 切入点表达式语法

基础语法：

[访问修饰符] 方法返回数值 包名.类名.方法名(参数)

```java
public void com.spring.UserDao.save(..)
//其中，public可以省略，其余部分都可以用*代替，表示任意值
* com.spring.UserDao.save(..)
```

在类名和方法名之间可以换成+号，表示指定类与其子类的所有指定方法

```java
//UserDao及其子类中的所有save方法
* com.spring.UserDao+save(..)
```

.可以换成两个，表示当前包及子包

```java
//com.spring及其子包下的所有类的所有方法
* com.spring..*.*(..)
```

### AOP入门（基于AspectJ的注解的方式）

#### 1.编写目标类并配置 

#### 2.编写切面类

#### 3.使用注解对AOP对象目标类进行增强

1. 在配置文件中打开注解的AOP开发

```xml
<!--在配置文件中开启注解的AOP开发-->
<aop:aspectj-autoproxy/>
```

2. 在切面类上使用注解

### 基于注解的AOP的通知类型

#### @Before 前置通知

```java
@Before(value = "execution(public void cn.andrew.spring.annotation.aop.OrderDao.save(..))")
```

#### @AfterReturning 后置通知

```java
@AfterReturning(value = "execution(public void cn.andrew.spring.annotation.aop.OrderDao.save(..))", returning="result")
public void afterReturning(Object result){}
```

#### @Around 环绕通知

```java
@Around(value = "execution(public void cn.andrew.spring.annotation.aop.OrderDao.save(..))")
public Object around(ProceedingJoinPoint joinPoint){
    //环绕前增强
    Object obj = joinPoint.proceed;
    //环绕后增强
    return obj;
}
```

#### @AfterThrowing 异常抛出通知

```java
@AfterThrowing(value = "execution(public void cn.andrew.spring.annotation.aop.OrderDao.save(..))", throwing="e")
public Object afterThrowing(Throwable e){
}
```

#### @After 最终通知

```java
@After(value = "execution(public void cn.andrew.spring.annotation.aop.OrderDao.save(..))")
public Object after(){
}
```

### 切入点的注解

