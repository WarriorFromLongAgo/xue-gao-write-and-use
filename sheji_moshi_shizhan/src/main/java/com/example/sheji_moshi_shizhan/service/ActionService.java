package com.example.sheji_moshi_shizhan.service;

import com.example.sheji_moshi_shizhan.domain.enums.ActionTypeEnum;

import java.util.HashMap;
import java.util.Map;

public interface ActionService {

    Map<ActionTypeEnum, ActionService> map = new HashMap<>();

    void processMsg();

    static ActionService getByAction(ActionTypeEnum actionTypeEnum) {
        return map.get(actionTypeEnum);
    }

}
