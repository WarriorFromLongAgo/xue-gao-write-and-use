package com.xuegao.mvc.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.core.Ordered;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TestFirstFilter implements Filter, Ordered {
    private static final Logger log = LoggerFactory.getLogger(TestFirstFilter.class);

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("[xue-gao-write-and-use][TestFirstFilter][doFilter][order={}]", getOrder());
        ObjectMapper objectMapper = new ObjectMapper();
        log.info("[xue-gao-write-and-use][TestFirstFilter][doFilter][getParameterMap={}]", objectMapper.writeValueAsString(servletRequest.getParameterMap()));

        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        ResponseWrapper mResp = new ResponseWrapper(resp);// 包装响应对象 resp 并缓存响应数据

        // 对request或 response 进行处理
        // 调用filter链中的下一个filter
        filterChain.doFilter(servletRequest, mResp);
        // ServletOutputStream outputStream = servletResponse.getOutputStream();
        // outputStream.println(servletResponse.getBufferSize());
        // outputStream.println();

        // PrintWriter writer = servletResponse.getWriter();
        // writer.println();

        // HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        byte[] bytes = mResp.getBytes();// 获取缓存的响应数据

        if (bytes.length > 0) {
            String responseStr = new String(bytes);
            log.info("[xue-gao-write-and-use][TestFirstFilter][返回值]={}", responseStr);
        }
        log.info("[xue-gao-write-and-use][TestFirstFilter][doFilter][order=end]");
        MDC.put("xuegao", "xuegao");
    }


    @Override
    public int getOrder() {
        return -1;
    }
}
