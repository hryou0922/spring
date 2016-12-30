package study.hry.spring.spi.interfa.imp;

import study.hry.spring.spi.interfa.Cmand;

public class ShutdownCommand implements Cmand {
    public void execute() {
        System.out.println("shutdown....");  
    }
}