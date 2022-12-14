package com.xuegao.testdynamictp.refresh;

import com.dtp.common.config.ThreadPoolProperties;
import com.dtp.core.refresh.AbstractRefresher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;

import java.util.List;

public class XuegaoRefresher extends AbstractRefresher implements InitializingBean {
    private static final Logger log = LoggerFactory.getLogger(XuegaoRefresher.class);

    @Override
    public void afterPropertiesSet() throws Exception {
        List<ThreadPoolProperties> executors = dtpProperties.getExecutors();


    }
}
