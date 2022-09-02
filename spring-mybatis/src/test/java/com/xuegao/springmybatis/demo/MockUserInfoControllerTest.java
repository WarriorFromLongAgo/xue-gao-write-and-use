package com.xuegao.springmybatis.demo;

import com.xuegao.JsonUtil;
import com.xuegao.springmybatis.business.demo.controller.UserInfoController;
import com.xuegao.springmybatis.business.demo.mapper.UserInfoMapper;
import com.xuegao.springmybatis.model.demo.doo.UserInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RunWith(SpringRunner.class)
// 使用@WebMvcTest只实例化Web层，而不是整个上下文。在具有多个Controller的应用程序中，
// 甚至可以要求仅使用一个实例化，例如@WebMvcTest(UserController.class)
@WebMvcTest(UserInfoController.class)
public class MockUserInfoControllerTest {
    private static final Logger log = LoggerFactory.getLogger(MockUserInfoControllerTest.class);

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserInfoMapper userInfoMapper;

    @Test
    public void batchInsert() throws Exception {
        Random random = new Random();
        int nextInt = random.nextInt();

        List<UserInfo> userInfoList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            UserInfo userInfo = new UserInfo();
            userInfo.setUsername(String.valueOf(nextInt));
            userInfo.setPassword(String.valueOf(nextInt));
            userInfoList.add(userInfo);
        }

        // 模拟 userInfoMapper.batchInsert(1)的行为
        Mockito.when(userInfoMapper.batchInsert(userInfoList)).thenReturn(1);

        String result = this.mockMvc.perform(MockMvcRequestBuilders.get("/userInfo/batchInsert"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8))
                // .andExpect(MockMvcResultMatchers.model().attributeExists("name"))
                // .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("张三"))
                .andReturn().getResponse().getContentAsString();
        System.out.println("result : " + result);
        log.info("[xue-gao-write-and-use][UserInfoControllerTest][batchInsert][userInfoList={}]", JsonUtil.toJsonString(userInfoList));
    }

}
