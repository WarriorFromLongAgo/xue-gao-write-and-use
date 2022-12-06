package javatest.util.optional.optional;

import com.alibaba.fastjson2.JSON;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Passing a non-null argument to 'Optional'
 */
public class OfNullableTest {
    public static void main(String[] args) {
        // test1();

        // test2();
        List<String> nullList = null;
        test2(nullList);
        List<String> notNullList = new ArrayList<>();
        test2(notNullList);


    }

    private static void test1() {
        List<String> nullList = null;
        String nullListStr = Optional.ofNullable(nullList).map(JSON::toJSONString).orElse(null);
        System.out.println(nullListStr);

        List<String> notNullList = new ArrayList<>();
        String notNullListStr = Optional.ofNullable(notNullList).map(JSON::toJSONString).orElse(null);
        System.out.println(notNullListStr);
    }

    private static void test2(List<String> inputList) {
        String listStr = Optional.ofNullable(inputList).map(JSON::toJSONString).orElse(null);
        System.out.println(listStr);
    }
}
