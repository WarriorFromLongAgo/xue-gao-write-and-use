package common.model.temp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class TempListBO {

    private Integer id;
    private String username;
    private String password;

    public static List<TempListBO> getList() {
        List<TempListBO> list = new ArrayList<>(5);
        for (int i = 0; i < 3; i++) {
            TempListBO tempListBO = new TempListBO();
            tempListBO.setId(i);
            tempListBO.setUsername("username" + i);
            tempListBO.setPassword("password" + i);
            list.add(tempListBO);
        }
        return list;
    }

    public static List<TempListBO> getListV2() {
        List<TempListBO> list = new ArrayList<>(5);
        for (int i = 0; i < 3; i++) {
            TempListBO tempListBO = new TempListBO();
            tempListBO.setId(i);
            tempListBO.setUsername("username");
            tempListBO.setPassword("password");
            list.add(tempListBO);
        }
        return list;
    }
}
