package org.xi.facade.components;

public class HardDrive {

    public byte[] read(long lba, int size) {
        System.out.println("硬盘读取位置开始位置：" + lba + "，读取结束位置：" + (lba + size));
        return "操作系统".getBytes();
    }
}
