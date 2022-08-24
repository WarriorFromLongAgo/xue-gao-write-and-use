package com.xuegao.mybatis.mapping;

import lombok.Data;

@Data
public class MyMapperStatement {

    private String namespace;

    private String crudType;

    private String id;

    private String parameterType;

    private String resultType;

    private String sql;
}
