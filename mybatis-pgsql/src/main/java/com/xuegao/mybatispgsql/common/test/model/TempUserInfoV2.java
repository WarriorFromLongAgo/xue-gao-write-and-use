package com.xuegao.mybatispgsql.common.test.model;

import lombok.Getter;
import lombok.Setter;

/**
 * @author xuegao
 * @version 1.0
 * @date 2022年11月26日 14:11
 */
@Getter
@Setter
public class TempUserInfoV2 {

    private Integer id;
    private String username;
    private String password;

    public TempUserInfoV2() {
    }

}
