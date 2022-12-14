package com.xuegao.testdynamictp.refresh;

import com.dtp.core.refresh.AbstractRefresher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;

/**
 * HttpRefresher related
 *
 * @author xuegao
 * @since 1.0.0
 **/
public class HttpRefresher extends AbstractRefresher implements InitializingBean {
    private static final Logger log = LoggerFactory.getLogger(HttpRefresher.class);

    @Override
    public void afterPropertiesSet() throws Exception {


    }
}
