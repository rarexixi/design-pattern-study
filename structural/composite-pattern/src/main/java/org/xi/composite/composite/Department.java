package org.xi.composite.composite;

import java.util.ArrayList;
import java.util.List;

public class Department implements Introductive {

    private String name;
    private Employee head;

    public Department(String name, Employee head) {
        this.name = name;
        this.head = head;
    }

    private List<Introductive> introductiveList = new ArrayList<>();

    @Override
    public void introduce() {
        System.out.println("部门：" + name);
        head.introduce();
        for (Introductive introductive : introductiveList) {
            introductive.introduce();
        }
    }

    public void add(Introductive introductive) {
        introductiveList.add(introductive);
    }

    public void remove(Introductive introductive) {
        introductiveList.remove(introductive);
    }
}
