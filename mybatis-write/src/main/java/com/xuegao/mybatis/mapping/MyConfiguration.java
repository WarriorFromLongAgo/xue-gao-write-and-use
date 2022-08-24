package com.xuegao.mybatis.mapping;

import lombok.Data;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Data
public class MyConfiguration {

    // mybatis-config.xml
    private MyEnvironment myEnvironment;

    // xxMapper.xml
    private Map<String , MyMapperStatement> mapperStatement;

    protected final Set<String> loadedResources = new HashSet<String>();

    public void addLoadedResource(String resource) {
        loadedResources.add(resource);
    }

    public boolean isResourceLoaded(String resource) {
        return loadedResources.contains(resource);
    }
}
