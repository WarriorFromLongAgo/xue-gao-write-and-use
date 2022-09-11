package com.xuegao.model.vo;

import com.xuegao.model.common.model.CommonModel;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TestResponse extends CommonModel {

    private String name;

    private List<String> infoList;
}
