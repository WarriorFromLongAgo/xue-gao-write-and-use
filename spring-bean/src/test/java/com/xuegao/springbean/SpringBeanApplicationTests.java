package com.xuegao.springbean;

import com.xuegao.springbean.imports.annotation.ImportMainService;
import com.xuegao.springbean.imports.implement.ImportMainService2;
import com.xuegao.springbean.imports.importregistrar.ImportMainService3;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBeanApplicationTests {

    @Autowired
    private ImportMainService importMainService;

    @Autowired
    private ImportMainService2 importMainService2;

    @Autowired
    private ImportMainService3 importMainService3;

    @Test
    void importMainService() {
        importMainService.test1();
    }

    @Test
    void importMainService2() {
        importMainService2.test1();
    }

    @Test
    void importMainService3() {
        importMainService3.test1();
    }
}
