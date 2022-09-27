package test;

import context.annotation.AnnotationConfigApplicationContext;

public class Test1 {

    public void test1(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();

        ac.getBean("aa");

    }

}
