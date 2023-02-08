package javatest.util.stream.collectors;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author xuegao
 * @version 1.0
 * @date 2023年02月08日 11:30
 */
public class 判断长度大于2 {

    public static void main(String[] args) {
        Set<String> set1 = getList().stream().collect(Collectors.toSet());
        if (set1.size() > 1) {
            System.out.println(" set1 有重复 ");
        }
        Optional<String> reduce = getList().stream().distinct().reduce((s, s2) -> s + s2);
        System.out.println(reduce);

    }

    public static List<String> getList() {
        return Lists.newArrayList("1", "2", "2", "3");
    }
}

