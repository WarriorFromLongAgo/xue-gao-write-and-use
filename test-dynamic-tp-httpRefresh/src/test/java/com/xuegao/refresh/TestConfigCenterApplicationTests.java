// package com.xuegao.refresh;
//
// import com.dtp.common.properties.DtpProperties;
// import com.dtp.common.properties.SimpleTpProperties;
// import com.dtp.common.properties.ThreadPoolProperties;
// import com.dtp.starter.http.controller.HttpRefreshController;
// import com.dtp.starter.http.refresh.HttpRefresher;
// import com.fasterxml.jackson.core.JsonProcessingException;
// import com.fasterxml.jackson.databind.ObjectMapper;
// import org.junit.jupiter.api.Test;
// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.context.SpringBootTest;
//
// import java.util.List;
//
// @SpringBootTest
// public class TestConfigCenterApplicationTests {
//     private static final Logger log = LoggerFactory.getLogger(TestConfigCenterApplicationTests.class);
//
//     @Autowired
//     private HttpRefreshController httpRefreshController;
//
//     @Autowired
//     private HttpRefresher httpRefresher;
//
//     @Test
//     public void httpRefresher() throws JsonProcessingException {
//         ObjectMapper objectMapper = new ObjectMapper();
//         DtpProperties dtpProperties = httpRefreshController.getDtpProperties();
//         log.info("[dtpProperties={}]", objectMapper.writeValueAsString(dtpProperties));
//         dtpProperties.setEnabledCollect(false);
//         SimpleTpProperties tomcatTp = dtpProperties.getTomcatTp();
//         tomcatTp.setCorePoolSize(96);
//         List<ThreadPoolProperties> executors = dtpProperties.getExecutors();
//         ThreadPoolProperties threadPoolProperties = executors.get(0);
//         threadPoolProperties.setCorePoolSize(96);
//         httpRefreshController.refresh(dtpProperties);
//
//         DtpProperties dtpPropertiesV2 = httpRefreshController.getDtpProperties();
//         log.info("[dtpPropertiesV2={}]", objectMapper.writeValueAsString(dtpPropertiesV2));
//     }
// }