package com.xuegao.springbean.beanextend;

import com.xuegao.springbean.util.OnlyPrintUtil;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bean130_CommandLineRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        OnlyPrintUtil.print(getClass(), "run");
    }
}
