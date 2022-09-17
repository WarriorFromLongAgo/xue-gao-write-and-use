package fanxing.supers;

public class test1 {
    public static void main(String[] args) {
        // 定义时指定T为Fruit
        // List<? super B> list2;
        // 实例化时只能是T本身或它的父类
        // list2 = new ArrayList<B>(); // 可以
        // list2 = new ArrayList<A>(); // 可以
        // list2 = new ArrayList<C>();  // 报错

        // List<? super B> list3 = new ArrayList<A>() {{
        //     add(new Object()); // 报错，上界为Food
        //     add(new A2()); // 可以，是Food的子类，即使不是Fruit
        //     add(new A()); // 可以
        //     add(new B()); // 可以，是Food的子类
        //     add(new C()); // 可以，是Food的子类
        // }};

        // list3.add(new A2());   // 报错，不是Fruit或其子类
        // list3.add(new A());   // 报错，不是Fruit或其子类
        // list3.add(new B());  // 可以
        // list3.add(new C());  // 可以

    }
}
