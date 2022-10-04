package com.xuegao.springbean.beanextend;

import com.xuegao.springbean.util.OnlyPrintUtil;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.stereotype.Component;

@Component
public class Bean_End_10_DisposableBean implements DisposableBean {
    @Override
    public void destroy() throws Exception {
        OnlyPrintUtil.print(getClass(), "destroy");
        // 调用时机
        // 销毁的时候

    }
}
