package generic.extend;

import common.model.B;

import java.util.List;

public class test1 {
    public static void main(String[] args) {
        // // 定义时指定T为Fruit
        List<? extends B> list;
        //
        // // 实例化时类只能是T本身或它的子类
        // list = new ArrayList<Fruit>(); //可以
        // list = new ArrayList<Apple>(); //可以
        // list = new ArrayList<Food>();  //报错

        // list = new ArrayList<Fruit>();
        // list.add(new Fruit()); //报错
        // list.add(null);  //可以
        // list.get(0); //可以

        // List<? extends Fruit> list2 = new ArrayList<Apple>() {{
        //     add(new Fruit()); // 实例化时指定的T为Apple，放入Fruit对象会报错
        //     add(new Apple()); // Apple及其子类都可以放进去
        // }};


    }

}
