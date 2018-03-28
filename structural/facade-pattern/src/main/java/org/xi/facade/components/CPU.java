package org.xi.facade.components;

public class CPU {

    public void freeze() {
        System.out.println("CPU 冻结");
    }

    public void jump(long position) {
        System.out.println("CPU 跳转位置：" + position);
    }

    public void execute() {
        System.out.println("CPU 执行");
    }
}
