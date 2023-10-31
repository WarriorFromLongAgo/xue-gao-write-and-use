package com.xuegao.model.dto;

import com.xuegao.model.common.model.CommonModel;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Getter
@Setter
public class TestRequest extends CommonModel {

    private String name;

    private List<String> infoList;

    private Long timeOut;

    private TimeUnit timeUnit;

}
