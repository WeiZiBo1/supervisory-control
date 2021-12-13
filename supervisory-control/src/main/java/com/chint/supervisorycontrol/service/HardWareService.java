package com.chint.supervisorycontrol.service;

import com.alibaba.fastjson.JSONObject;
import com.chint.supervisorycontrol.constants.ResponseMessage;
import com.chint.supervisorycontrol.vo.hardwareVO.*;

/**
 * @author zhouying3
 */
public interface HardWareService {

    /**
     * 硬件列表
     * @param vo “硬件搜搜参数”
     * @return success
     */
    ResponseMessage<JSONObject> listHardware(ListHardwareVO vo);

    /**
     * 硬件版本信息（单个）
     * @param vo “硬件搜搜参数”
     * @return success
     */
    ResponseMessage<JSONObject> getHardware(GetHardwareVO vo);

    /**
     添加硬件版本
     * @param vo “添加硬件版本”
     * @return success
     */
    ResponseMessage<JSONObject> addHardware(AddHardwareVO vo);

    /**
     更新硬件版本
     * @param vo “更新硬件版本”
     * @return success
     */
    ResponseMessage<JSONObject> updateHardware(UpdateHardwareVO vo);

    /**
     删除硬件版本
     * @param vo “删除硬件版本”
     * @return success
     */
    ResponseMessage<JSONObject> removeHardware(RemoveHardwareVO vo);
}
