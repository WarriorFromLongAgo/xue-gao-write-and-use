package com.xuegao.mybatispgsql;

import com.xuegao.mybatispgsql.common.test.model.TempUserInfoV2;
import com.xuegao.mybatispgsql.business.test.controller.TempUserInfoV2Controller;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class MybatisPgsqlApplicationTests {

    @Autowired
    private TempUserInfoV2Controller tempUserInfoV2Controller;

    @Test
    public void batchInsert() {
        List<TempUserInfoV2> tempUserInfoV2List = new ArrayList<>(10);
        for (int i = 0; i < 5; i++) {
            TempUserInfoV2 tempUserInfoV2 = new TempUserInfoV2();
            tempUserInfoV2.setUsername("username" + i);
            tempUserInfoV2.setPassword("password" + i);
            tempUserInfoV2List.add(tempUserInfoV2);
        }
        tempUserInfoV2Controller.batchInsert(tempUserInfoV2List);
    }

    @Test
    public void selectByInput() {
        tempUserInfoV2Controller.selectByInput();
    }

    @Test
    public void updatePassword() {
        TempUserInfoV2 tempUserInfoV2 = new TempUserInfoV2();
        tempUserInfoV2.setId(16);
        tempUserInfoV2.setPassword("55555555555555555555555");
        tempUserInfoV2Controller.updatePassword(tempUserInfoV2);
    }
}
