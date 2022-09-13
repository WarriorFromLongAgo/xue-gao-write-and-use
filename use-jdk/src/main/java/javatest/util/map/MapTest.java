package javatest.util.map;

import com.xuegao.util.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class MapTest {
    private static final Logger log = LoggerFactory.getLogger(MapTest.class);

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        keyNullValueNull(map);
    }

    public static void keyNullValueNull(Map<String, String> map) {
        for (int i = 0; i < 3; i++) {
            map.put(null, null);
        }
        // 长度永远为 1
        log.info("[xue-gao-write-and-use][MapTest][keyNullValueNull][={}]", JsonUtil.toJsonString(map));
    }
}
