package org.xi.composite.composite;

public class Employee implements Introductive {

    private String name;
    private String type;

    public Employee(String name, String type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public void introduce() {
        System.out.println("负责人：" + name + "，职位：" + type);
    }
}
