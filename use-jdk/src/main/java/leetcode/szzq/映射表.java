package leetcode.szzq;

import java.util.Comparator;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import java.util.function.BiFunction;

public class 映射表 {

    public static class Factory {
        public static final int A = 3;
        public static final int B = 5;
        public static final int C = 7;
        public static final Map<Integer, BiFunction<Integer, StringBuilder, Integer>> MAP = new TreeMap<>(Comparator.comparing(Integer::intValue));
        // BiFunction<Integer, StringBuilder, Integer>
        // 第一个是入参,第二个也是入参,第三个是返参

        static {
            new A();
            new B();
            new C();
        }

        private Factory() {
        }
    }

    static class A {
        static {
            Factory.MAP.put(Factory.A, new BiFunction<Integer, StringBuilder, Integer>() {
                @Override
                public Integer apply(Integer input, StringBuilder stringBuilder) {
                    if (input % Factory.A == 0) {
                        stringBuilder.append("A");
                        return input / Factory.A;
                    }
                    return input;
                }
            });
        }
    }

    static class B {
        static {
            Factory.MAP.put(Factory.B, new BiFunction<Integer, StringBuilder, Integer>() {
                @Override
                public Integer apply(Integer input, StringBuilder stringBuilder) {
                    if (input % Factory.B == 0) {
                        stringBuilder.append("B");
                        return input / Factory.B;
                    }
                    return input;
                }
            });
        }
    }

    static class C {
        static {
            Factory.MAP.put(Factory.C, new BiFunction<Integer, StringBuilder, Integer>() {
                @Override
                public Integer apply(Integer input, StringBuilder stringBuilder) {
                    if (input % Factory.C == 0) {
                        stringBuilder.append("C");
                        return input / Factory.C;
                    }
                    return input;
                }
            });
        }
    }

    public String getCase(Integer age) {
        if (Objects.isNull(age) || age <= 0 || age > 100) {
            return null;
        }
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<Integer, BiFunction<Integer, StringBuilder, Integer>> entry : Factory.MAP.entrySet()) {
            age = entry.getValue().apply(age, builder);
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(" =============== ");
        for (int i = 0; i < 101; i++) {
            String aCase = new 映射表().getCase(i);
            System.out.println(i + " === " + aCase);
        }
    }
}
