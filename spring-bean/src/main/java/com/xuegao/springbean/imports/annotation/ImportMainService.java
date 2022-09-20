package com.xuegao.springbean.imports.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Service;

@Service
@Import(ImportTestService.class)
public class ImportMainService {

    @Autowired
    private ImportTestService importTestService;

    public void test1() {
        importTestService.test1();
        System.out.println("ImportMainService test1");
    }

}
