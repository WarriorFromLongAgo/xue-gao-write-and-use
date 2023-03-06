package javatest.util.optional.optional;

import com.alibaba.fastjson2.JSON;
import com.google.common.collect.Lists;
import com.xuegao.util.JsonUtil;
import common.model.temp.TempListBO;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;

/**
 * Passing a non-null argument to 'Optional'
 */
public class OfNullableTest {
    public static void main(String[] args) {
        // test1();

        // test2();
        // List<String> nullList = null;
        // test3(nullList);
        // List<String> notNullList = new ArrayList<>();
        // test3(notNullList);
        // List<String> strList = Lists.newArrayList("1", "2");
        // test3(strList);

        List<TempListBO> nullList = null;
        test3(nullList);
        List<TempListBO> notNullList = new ArrayList<>();
        test3(notNullList);
        List<TempListBO> strList = TempListBO.getList();
        test3(strList);
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

    private static void test3(List<TempListBO> tempListBOList) {
        System.out.println("==============================================");
        System.out.println("入参 = " + JsonUtil.toJsonString(tempListBOList));
        String nullListStr = Optional.ofNullable(tempListBOList).map(JSON::toJSONString).orElse(null);
        System.out.println("nullListStr = " + nullListStr);

        String notNullListStr = Optional.ofNullable(tempListBOList)
                .flatMap(c -> c.stream().filter(Objects::nonNull).findFirst())
                .map(JsonUtil::toJsonString).orElse(null);
        System.out.println("notNullListStr = " + notNullListStr);
    }

}
