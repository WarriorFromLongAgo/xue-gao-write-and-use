package com.example.sheji_moshi_shizhan.domain.enums;

public enum ActionTypeEnum {
    Actoin_1("1", "111"),
    Actoin_2("2", "2222"),

    ;

    private final String code;
    private final String msg;

    ActionTypeEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
