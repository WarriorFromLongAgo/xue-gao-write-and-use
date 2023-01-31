/**************************************************************************/
/*                                                                        */
/* Copyright (c) 2017 KYE Company                                         */
/* 跨越速运集团有限公司版权所有                                             */
/*                                                                        */
/* PROPRIETARY RIGHTS of KYE Company are involved in the                  */
/* subject matter of this material. All manufacturing, reproduction, use, */
/* and sales rights pertaining to this subject matter are governed by the */
/* license agreement. The recipient of this software implicitly accepts   */
/* the terms of the license.                                              */
/* 本软件文档资料是跨越速运集团有限公司的资产，任何人士阅读和                  */
/* 使用本资料必须获得相应的书面授权，承担保密责任和接受相应的法律约束。         */
/*                                                                        */
/**************************************************************************/

package com.xuegao.springbean.beantest.controller;

import com.xuegao.springbean.beantest.service.Test2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author fjm
 * @version 1.0
 * @date 2023年01月30日 17:11
 */
@RestController
public class Test2Controller {

    @Autowired
    private Test2 test2;

    @GetMapping("/test2")
    public void test(@RequestParam(name = "name") String name) {
        test2.test(name);
    }


}
