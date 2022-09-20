package com.xuegao.springbean.imports.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Service;

@Service
@Import(ImportSelectorTest.class)
public class ImportMainService2 {

    @Autowired
    private ImportTestService2 importTestService2;

    public void test1() {
        importTestService2.test1();
        System.out.println("ImportMainService2 test1");
    }

}
