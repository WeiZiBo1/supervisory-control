package com.chint.supervisorycontrol.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.chint.supervisorycontrol.constants.ResponseMessage;
import com.chint.supervisorycontrol.service.HardWareService;
import com.chint.supervisorycontrol.vo.hardwareVO.*;
import org.springframework.stereotype.Service;

/**
 * @author zhouying3
 */
@Service
public class HardWareServiceImpl implements HardWareService {
    @Override
    public ResponseMessage<JSONObject> listHardware(ListHardwareVO vo) {
        return null;
    }

    @Override
    public ResponseMessage<JSONObject> getHardware(GetHardwareVO vo) {
        return null;
    }

    @Override
    public ResponseMessage<JSONObject> addHardware(AddHardwareVO vo) {
        return null;
    }

    @Override
    public ResponseMessage<JSONObject> updateHardware(UpdateHardwareVO vo) {
        return null;
    }

    @Override
    public ResponseMessage<JSONObject> removeHardware(RemoveHardwareVO vo) {
        return null;
    }
}
