package cn.andrew.spring.annotation.aop;

public class OrderDao {

    public void save(){
        System.out.println("save order...");
    }

    public void update(){
        System.out.println("update order...");
    }

    public void find(){
        System.out.println("find order...");
    }

    public void delete(){
        System.out.println("delete order...");
    }
}
