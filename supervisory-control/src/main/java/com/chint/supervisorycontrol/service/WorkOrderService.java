package com.chint.supervisorycontrol.service;

import com.alibaba.fastjson.JSONObject;
import com.chint.supervisorycontrol.constants.ResponseMessage;
import com.chint.supervisorycontrol.vo.workorderVO.ListWorkOrderInfoVO;
import com.chint.supervisorycontrol.vo.workorderVO.RemoveWorkOrderVO;

/**
 * @author zhouying3
 */
public interface WorkOrderService {

    /**
     * 日志列表
     * @param vo “日志列表”
     * @return success
     */
    ResponseMessage<JSONObject> listWorkOrderInfo(ListWorkOrderInfoVO vo);

    /**
     * 删除工单
     * @param vo “删除工单”
     * @return success
     */
    ResponseMessage<JSONObject> removeWorkOrder(RemoveWorkOrderVO vo);
}
