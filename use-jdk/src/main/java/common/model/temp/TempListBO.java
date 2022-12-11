package common.model.temp;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class TempListBO {

    private Integer id;
    private String username;
    private String password;

    public static List<TempListBO> getList() {
        List<TempListBO> list = new ArrayList<>(5);
        for (int i = 0; i < 5; i++) {
            TempListBO tempListBO = new TempListBO();
            tempListBO.setId(i);
            tempListBO.setUsername("username" + i);
            tempListBO.setPassword("password" + i);
            list.add(tempListBO);
        }
        return list;
    }
}
