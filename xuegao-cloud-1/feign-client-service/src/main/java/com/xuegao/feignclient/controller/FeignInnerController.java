// package com.xuegao.feignclient.controller;
//
// import com.xuegao.feignclient.call.feignserver2.FeignInnerCall;
// import com.xuegao.model.vo.TestResponse;
// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestMethod;
// import org.springframework.web.bind.annotation.RestController;
//
// @RestController
// public class FeignInnerController {
//     private static final Logger log = LoggerFactory.getLogger(FeignInnerController.class);
//
//     @Autowired
//     private FeignInnerCall feignInnerCall;
//
//     @RequestMapping(path = "/feignInner/test1", method = RequestMethod.GET)
//     public TestResponse test1() {
//         return feignInnerCall.test1();
//     }
// }
