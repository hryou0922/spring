package study.hry.spring.spi;

import java.util.ServiceLoader;

import study.hry.spring.spi.interfa.Cmand;

public class SPIMain {
    public static void main(String[] args) {
        ServiceLoader<Cmand> loader = ServiceLoader.load(Cmand.class);
        System.out.println(loader);
        
        
        for (Cmand Cmand : loader) {
            Cmand.execute();
        }
    }
}
