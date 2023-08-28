package javatest.util.map;

import common.model.temp.TempListBO;

import java.util.function.Function;
import java.util.stream.Collectors;

public class Function_identity {
    public static void main(String[] args) {

        TempListBO.getListV2()
                .stream().collect(Collectors.
                        toMap(TempListBO::getUsername, Function.identity()));

    }
}
