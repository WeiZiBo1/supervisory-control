package com.chint.supervisorycontrol.controller;

import com.alibaba.fastjson.JSONObject;
import com.chint.supervisorycontrol.constants.ResponseMessage;
import com.chint.supervisorycontrol.service.WorkOrderService;
import com.chint.supervisorycontrol.vo.workorderVO.ListWorkOrderInfoVO;
import com.chint.supervisorycontrol.vo.workorderVO.RemoveWorkOrderVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


/**
 * @author zhouying3
 */
@RestController
@RequestMapping("/work-order-management")
@Api(value = "工单接口", tags = "工单接口")
@AllArgsConstructor
public class WorkOrderController {
    private final WorkOrderService workOrderService;
    /**
     * 日志列表
     */
    @RequestMapping(value = "/workOrderInfo", method = RequestMethod.GET)
    @ApiOperation(value = "日志列表", notes = "日志列表")
    public ResponseMessage<JSONObject> listWorkOrderInfo(ListWorkOrderInfoVO vo) {
        return workOrderService.listWorkOrderInfo(vo);
    }

    /**
     * 删除工单
     */
    @RequestMapping(value = "/workOrder", method = RequestMethod.DELETE)
    @ApiOperation(value = "删除工单", notes = "删除工单")
    public ResponseMessage<JSONObject> removeWorkOrder(@Valid RemoveWorkOrderVO vo, BindingResult result) {
        boolean b = result.hasErrors();
         return workOrderService.removeWorkOrder(vo);
    }
}
