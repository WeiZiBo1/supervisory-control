package com.chint.supervisorycontrol.service;

import com.alibaba.fastjson.JSONObject;
import com.chint.supervisorycontrol.constants.ResponseMessage;
import com.chint.supervisorycontrol.vo.gatewayVO.*;

/**
 * @author zhouying3
 */
public interface GatewayService {
    /**
     * 网关统计数据
     * @param vo “网关统计数据参数”
     * @return success
     */
        ResponseMessage<JSONObject> listGatewayData(ListGatewayDataVO vo);
    /**
     * 网关状态
     * @return success
     */
    ResponseMessage listGatewayState();

    /**
     * 网关列表
     * @param vo “搜索参数”
     * @return success
     */
    ResponseMessage listGateways(ListGatewaysVO vo);

    /**
     * 添加网关
     * @param vo “网关参数”
     * @return success
     */
    ResponseMessage<JSONObject> addGateway(AddGatewaysVO vo);

    /**
     * 更新网关
     * @param vo “网关参数”
     * @return success
     */
    ResponseMessage<JSONObject> updateGateway(UpdateGatewayVO vo);

    ResponseMessage<JSONObject> updateGatewayName(UpdateGatewayNameVO vo);

    ResponseMessage<JSONObject> updateGatewayAllocation(UpdateGatewayAllocationVO vo);
}
