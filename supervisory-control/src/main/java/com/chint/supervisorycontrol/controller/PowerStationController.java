package com.chint.supervisorycontrol.controller;

import com.alibaba.fastjson.JSONObject;
import com.chint.supervisorycontrol.constants.ResponseMessage;
import com.chint.supervisorycontrol.service.PowerStationService;
import com.chint.supervisorycontrol.vo.powerStationVO.*;
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
@RequestMapping("powerStation-management")
@Api(value = "电站接口", tags = "电站接口")
@AllArgsConstructor
public class PowerStationController {
    private final PowerStationService powerStationService;

    /**
     * 电站数据
     */
    @RequestMapping(value = "/powerStationsData", method = RequestMethod.GET)
    @ApiOperation(value = "电站数据", notes = "电站数据")
    public ResponseMessage<JSONObject> listPowerStationData(ListPowerStationDataVO vo) {
        return powerStationService.listPowerStationData(vo);
    }

    /**
     * 电站列表
     */
    @RequestMapping(value = "/powerStationInfo", method = RequestMethod.GET)
    @ApiOperation(value = "电站列表", notes = "电站列表")
    public ResponseMessage listPowerStations(ListPowerStationVO vo) {

        return powerStationService.listPowerStations(vo);
    }

    /**
     * 电站详细信息
     */
    @RequestMapping(value = "/powerStation", method = RequestMethod.GET)
    @ApiOperation(value = "电站详细", notes = "电站详细")
    public ResponseMessage<JSONObject> getPowerStationInfo(GetPowerStationInfoVO vo) {
        return powerStationService.getPowerStationInfo(vo);
    }

    /**
     * 添加电站
     */
    @RequestMapping(value = "/powerStation", method = RequestMethod.POST)
    @ApiOperation(value = "添加电站", notes = "添加电站")
    public ResponseMessage<JSONObject> addPowerStation(AddPowerStationVO vo) {

        return powerStationService.addPowerStation(vo);
    }

    /**
     * 更新电站
     */
    @RequestMapping(value = "/powerStation", method = RequestMethod.PUT)
    @ApiOperation(value = "更新电站", notes = "更新电站")
    public ResponseMessage<JSONObject> updatePowerStation(UpdatePowerStationVO vo) {

        return powerStationService.updatePowerStation(vo);
    }

    /**
     * 删除电站
     */
    @RequestMapping(value = "/powerStation", method = RequestMethod.DELETE)
    @ApiOperation(value = "删除电站", notes = "删除电站")
    public ResponseMessage removePowerStation(RemovePowerStationVO vo) {

        return powerStationService.removePowerStation(vo);
    }

    /**
     * 电站统计(单个)
     */
    @RequestMapping(value = "/powerStationStatistics", method = RequestMethod.GET)
    @ApiOperation(value = "电站统计(单个)", notes = "电站统计(单个)")
    public ResponseMessage getPowerStationStatistics(PowerStationStatisticsVO vo) {
        return powerStationService.getPowerStationStatistics(vo);
    }

    /**
     * 电站设备列表(单个)
     */
    @RequestMapping(value = "/powerStationEquipment", method = RequestMethod.GET)
    @ApiOperation(value = "电站设备列表(单个)", notes = "电站设备列表(单个)")
    public ResponseMessage<JSONObject> getPowerStationEquipment(PowerStationEquipmentVO vo) {
        return powerStationService.getPowerStationEquipment(vo);
    }

    /**
     * 导出电站数据
     */
    @RequestMapping(value = "/exportPowerStationData", method = RequestMethod.GET)
    @ApiOperation(value = "导出电站数据", notes = "导出电站数据")
    public ResponseMessage<JSONObject> exportPowerStationData(ExportPowerStationDataVO vo) {
        return powerStationService.exportPowerStationData(vo);
    }
}
