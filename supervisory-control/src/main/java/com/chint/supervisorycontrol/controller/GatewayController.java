package com.chint.supervisorycontrol.controller;

import com.alibaba.fastjson.JSONObject;
import com.chint.supervisorycontrol.constants.ResponseMessage;
import com.chint.supervisorycontrol.service.GatewayService;
import com.chint.supervisorycontrol.vo.gatewayVO.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhouying3
 */
@RestController
@RequestMapping("/gateway-management")
@Api(value = "日志接口", tags = "日志接口")
@AllArgsConstructor
public class GatewayController {

    private final GatewayService gatewayService;

    /**
     * 网关统计数据
     */
    @RequestMapping(value = "/gatewayData", method = RequestMethod.GET)
    @ApiOperation(value = "网关统计数据", notes = "网关统计数据")
    public ResponseMessage<JSONObject> listGatewayData(ListGatewayDataVO vo) {
        return gatewayService.listGatewayData(vo);
    }

    /**
     * 网关状态数据
     */
    @RequestMapping(value = "/gatewayState", method = RequestMethod.GET)
    @ApiOperation(value = "网关状态数据", notes = "网关状态数据")
    public ResponseMessage listGatewayState() {
        return gatewayService.listGatewayState();
    }

    /**
     * 网关列表
     */
    @RequestMapping(value = "/gatewayInfo", method = RequestMethod.GET)
    @ApiOperation(value = "网关列表", notes = "网关列表")
    public ResponseMessage listGateways(ListGatewaysVO vo) {
        return gatewayService.listGateways(vo);
    }

    /**
     * 添加网关
     */
    @RequestMapping(value = "/gateway", method = RequestMethod.POST)
    @ApiOperation(value = "添加网关", notes = "添加网关")
    public ResponseMessage<JSONObject> addGateway(AddGatewaysVO vo) {
        return gatewayService.addGateway(vo);
    }


    /**
     * 更新网关
     */
    @RequestMapping(value = "/gateway", method = RequestMethod.PUT)
    @ApiOperation(value = "更新网关", notes = "更新网关")
    public ResponseMessage<JSONObject> updateGateway(UpdateGatewayVO vo) {
        return gatewayService.updateGateway(vo);
    }

    /**
     * 网关重命名
     */
    @RequestMapping(value = "/gatewayName", method = RequestMethod.PUT)
    @ApiOperation(value = "更新网关", notes = "更新网关")
    public ResponseMessage<JSONObject> updateGatewayName(UpdateGatewayNameVO vo) {
        return gatewayService.updateGatewayName(vo);
    }

    /**
     * 分配网关
     */
    @RequestMapping(value = "/gatewayAllocation", method = RequestMethod.PUT)
    @ApiOperation(value = "分配网关", notes = "分配网关")
    public ResponseMessage<JSONObject> updateGatewayAllocation(UpdateGatewayAllocationVO vo) {
        return gatewayService.updateGatewayAllocation(vo);
    }
}
