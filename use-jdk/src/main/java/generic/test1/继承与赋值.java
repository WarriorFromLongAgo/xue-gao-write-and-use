package generic.test1;

import model.A;
import model.A2;

import java.util.ArrayList;
import java.util.List;

public class 继承与赋值 {

    public static void main(String[] args) {
        A a = new A();

        A2 a2 = new A2();

        a = a2;

        List<A> aList = new ArrayList<>();
        List<A2> a2List = new ArrayList<>();

        // 正常
        // aList.addAll(a2List);
        // 报错
        // a2List.add(aList);


    }


}
