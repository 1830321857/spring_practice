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