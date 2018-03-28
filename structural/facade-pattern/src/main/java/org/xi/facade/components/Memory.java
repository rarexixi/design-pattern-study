package org.xi.facade.components;

public class Memory {

    public void load(long position, byte[] data) {
        System.out.println("内存加载位置：" + position + "，加载内容：" + new String(data));
    }
}
