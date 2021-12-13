package com.chint.supervisorycontrol.service;

import com.alibaba.fastjson.JSONObject;
import com.chint.supervisorycontrol.constants.ResponseMessage;
import com.chint.supervisorycontrol.vo.powerStationVO.*;

/**
 * @author zhouying3
 */
public interface PowerStationService {

    /**
     * 电站数据
     * @param vo “电站数据”
     * @return success
     */
    ResponseMessage<JSONObject> listPowerStationData(ListPowerStationDataVO vo);

    /**
     * 电站列表
     * @param vo “电站列表”
     * @return success
     */
    ResponseMessage listPowerStations(ListPowerStationVO vo);


    /**
     * 电站详细
     * @param vo “电站详细”
     * @return success
     */
    ResponseMessage<JSONObject> getPowerStationInfo(GetPowerStationInfoVO vo);


    /**
     * 添加电站
     * @param vo “添加电站”
     * @return success
     */
    ResponseMessage<JSONObject> addPowerStation(AddPowerStationVO vo);


    /**
     * 电站统计(单个)
     * @param vo “电站统计(单个)”
     * @return success
     */
    ResponseMessage getPowerStationStatistics(PowerStationStatisticsVO vo);


    /**
     * 电站设备列表(单个)
     * @param vo “电站设备列表(单个)”
     * @return success
     */
    ResponseMessage<JSONObject> getPowerStationEquipment(PowerStationEquipmentVO vo);


    /**
     * 导出电站数据
     * @param vo “导出电站数据”
     * @return success
     */
    ResponseMessage<JSONObject> exportPowerStationData(ExportPowerStationDataVO vo);

    /**
     * 删除电站
     * @param vo “删除电站”
     * @return success
     */
    ResponseMessage removePowerStation(RemovePowerStationVO vo);

    /**
     * 更新电站
     * @param vo “更新电站”
     * @return success
     */
    ResponseMessage<JSONObject> updatePowerStation(UpdatePowerStationVO vo);
}
