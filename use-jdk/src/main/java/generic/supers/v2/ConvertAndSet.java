package generic.supers.v2;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public abstract class ConvertAndSet<T, T1, T2> {

    void convert() {
        TempBO tempBO = new TempBO();


    }

    @Getter
    @Setter
    @ToString
    public static class TempBO {
        private Integer id;
        private String username;
        private String password;
    }

    @Getter
    @Setter
    @ToString
    public static class TempBO1 {
        private Integer id;
        private String username;
        private String password;
    }
}
