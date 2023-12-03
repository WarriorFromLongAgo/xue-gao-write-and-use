package com.example.sheji_moshi_shizhan.controller;

import com.example.sheji_moshi_shizhan.domain.enums.ActionTypeEnum;
import com.example.sheji_moshi_shizhan.service.ActionService;
import com.example.sheji_moshi_shizhan.service.ActionServiceImplV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ActionController {

    @Autowired
    private ActionServiceImplV2 actionServiceImplV2;

    @GetMapping("/msg")
    public void msg() {
        ActionService byAction = ActionService.getByAction(ActionTypeEnum.Actoin_1);
        byAction.processMsg();

        actionServiceImplV2.processMsg();
        System.out.println("dajkdjkajdka");
    }


}
