package check.check;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.ObjectUtils;

public class CheckUtil {
    public static void main(String[] args) {
        System.out.println("null应该返回 true，" + isRealEmpty(null));
        System.out.println("Integer应该返回 false，" + isRealEmpty(1));
        System.out.println("空字符串应该返回 true，" + isRealEmpty(""));
        System.out.println("全是空格字符串应该返回 true，" + isRealEmpty("     "));
        System.out.println("非空字符串应该返回 false，" + isRealEmpty("  1 "));
        System.out.println("空list应该返回 true，" + isRealEmpty(Lists.newArrayList()));
        System.out.println("非空list应该返回 false，" + isRealEmpty(Lists.newArrayList("1")));

    }

    public static boolean isRealEmpty(Object object) {
        if (object == null) {
            return true;
        }
        if (object instanceof String) {
            System.out.print("走这里 = " + object);
            System.out.print("============");
            return StringUtils.isBlank(object.toString());
        }
        System.out.print("走这里 = " + object);
        System.out.print("============");
        return ObjectUtils.isEmpty(object);
    }

}

