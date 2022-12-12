package javatest.util.comparator;

import com.xuegao.util.JsonUtil;
import common.model.temp.TempListBO;

import java.util.Comparator;
import java.util.List;

public class ComparatorTest1 {
    public static void main(String[] args) {
        List<TempListBO> list = TempListBO.getList();
        list.sort(Comparator.comparing(TempListBO::getId));
        System.out.println(JsonUtil.toJsonString(list));
        System.out.println("====================================");
        list.sort(Comparator.comparing(TempListBO::getId).reversed());
        System.out.println(JsonUtil.toJsonString(list));

    }


}
