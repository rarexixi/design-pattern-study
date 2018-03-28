package org.xi.facade.facade;

import org.xi.facade.components.CPU;
import org.xi.facade.components.HardDrive;
import org.xi.facade.components.Memory;

public class ComputerFacade {

    final static long BOOT_ADDRESS = 0x100000;
    final static long BOOT_SECTOR = 0x2000000;
    final static int SECTOR_SIZE = 0x200000;

    private CPU processor;
    private Memory ram;
    private HardDrive hd;

    public ComputerFacade() {
        this.processor = new CPU();
        this.ram = new Memory();
        this.hd = new HardDrive();
    }

    public void start() {
        processor.freeze();
        ram.load(BOOT_ADDRESS, hd.read(BOOT_SECTOR, SECTOR_SIZE));
        processor.jump(BOOT_ADDRESS);
        processor.execute();
    }
}
