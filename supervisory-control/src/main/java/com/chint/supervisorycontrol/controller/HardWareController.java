package com.chint.supervisorycontrol.controller;

import com.alibaba.fastjson.JSONObject;
import com.chint.supervisorycontrol.constants.ResponseMessage;
import com.chint.supervisorycontrol.service.HardWareService;
import com.chint.supervisorycontrol.vo.hardwareVO.*;
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
@RequestMapping("/hardware-management")
@Api(value = "硬件接口", tags = "硬件接口")
@AllArgsConstructor
public class HardWareController {
    private final HardWareService hardWareService;
    /**
     * 硬件列表
     */
    @RequestMapping(value = "/hardwareInfo", method = RequestMethod.GET)
    @ApiOperation(value = "硬件列表", notes = "硬件列表")
    public ResponseMessage<JSONObject> listHardware(ListHardwareVO vo) {

        return hardWareService.listHardware(vo);
    }

    /**
     * 硬件版本信息（单个）
     */
    @RequestMapping(value = "/hardware", method = RequestMethod.GET)
    @ApiOperation(value = "硬件版本信息（单个）", notes = "硬件版本信息（单个）")
    public ResponseMessage<JSONObject> getHardware(GetHardwareVO vo) {

        return hardWareService.getHardware(vo);
    }

    /**
     * 添加硬件版本
     */
    @RequestMapping(value = "/hardware", method = RequestMethod.POST)
    @ApiOperation(value = "添加硬件版本", notes = "添加硬件版本")
    public ResponseMessage<JSONObject> addHardware(AddHardwareVO vo) {

        return hardWareService.addHardware(vo);
    }

    /**
     * 更新硬件版本
     */
    @RequestMapping(value = "/hardware", method = RequestMethod.PUT)
    @ApiOperation(value = "更新硬件版本", notes = "更新硬件版本")
    public ResponseMessage<JSONObject> updateHardware(UpdateHardwareVO vo) {

        return hardWareService.updateHardware(vo);
    }

    /**
     * 删除硬件版本
     */
    @RequestMapping(value = "/hardware", method = RequestMethod.DELETE)
    @ApiOperation(value = "删除硬件版本", notes = "删除硬件版本")
    public ResponseMessage<JSONObject> removeHardware(RemoveHardwareVO vo) {

        return hardWareService.removeHardware(vo);
    }
}
