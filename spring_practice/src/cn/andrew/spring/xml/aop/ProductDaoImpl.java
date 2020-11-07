package cn.andrew.spring.xml.aop;

public class ProductDaoImpl implements ProductDao{
    @Override
    public void save() {
        System.out.println("save product");
    }

    @Override
    public void update() {
        System.out.println("update product");
    }

    @Override
    public void find() {
        System.out.println("find product");
        int i = 1 / 0;
    }

    @Override
    public String delete() {
        System.out.println("delete product");
        return "笔记本";
    }
}
