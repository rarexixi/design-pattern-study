package org.xi.composite;


import org.xi.composite.composite.Employee;
import org.xi.composite.composite.Department;

public class Main {

    public static void main(String[] args) {

        Department company = new Department("天气预报公司", new Employee("王先生", "CEO"));

        Department operation  = new Department("运营部", new Employee("老毕", "COO"));
        Department finance = new Department("财务部", new Employee("老李","CFO"));
        Department technology = new Department("技术部", new Employee("老朱", "CTO"));

        Department web = new Department("前端部", new Employee("王总监", "技术总监"));
        Department back = new Department("后端部", new Employee("陈总监", "技术总监"));

        company.add(operation);
        company.add(finance);
        company.add(technology);

        technology.add(web);
        technology.add(back);

        company.introduce();
    }
}
