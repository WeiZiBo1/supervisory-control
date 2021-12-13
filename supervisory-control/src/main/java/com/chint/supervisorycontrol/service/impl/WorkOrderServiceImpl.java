package com.chint.supervisorycontrol.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.chint.supervisorycontrol.constants.ResponseMessage;
import com.chint.supervisorycontrol.service.WorkOrderService;
import com.chint.supervisorycontrol.vo.workorderVO.ListWorkOrderInfoVO;
import com.chint.supervisorycontrol.vo.workorderVO.RemoveWorkOrderVO;
import org.springframework.stereotype.Service;

/**
 * @author zhouying3
 */
@Service
public class WorkOrderServiceImpl implements WorkOrderService {
    @Override
    public ResponseMessage<JSONObject> listWorkOrderInfo(ListWorkOrderInfoVO vo) {
        return null;
    }

    @Override
    public ResponseMessage<JSONObject> removeWorkOrder(RemoveWorkOrderVO vo) {
        Long workerOrderId = vo.getWorkerOrderId();
        return ResponseMessage.success();
    }
}
