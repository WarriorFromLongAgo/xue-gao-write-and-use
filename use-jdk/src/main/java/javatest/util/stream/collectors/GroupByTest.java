package javatest.util.stream.collectors;

import com.xuegao.util.JsonUtil;
import model.temp.TempListBO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupByTest {
    private static final Logger log = LoggerFactory.getLogger(GroupByTest.class);

    public static void main(String[] args) {
        List<TempListBO> tempListBOList = TempListBO.getList();

        Map<Integer, List<TempListBO>> conditionCodeMap1 = tempListBOList.stream()
                .collect(Collectors.groupingBy(TempListBO::getId));
        log.info("[xue-gao-write-and-use][GroupByTest][main][1={}]", JsonUtil.toJsonString(conditionCodeMap1));

        Map<Integer, List<String>> conditionCodeMap2 = tempListBOList.stream()
                .collect(Collectors.groupingBy(TempListBO::getId,
                        Collectors.mapping(TempListBO::getUsername, Collectors.toList())));
        log.info("[xue-gao-write-and-use][GroupByTest][main][2={}]", JsonUtil.toJsonString(conditionCodeMap2));


    }
}
