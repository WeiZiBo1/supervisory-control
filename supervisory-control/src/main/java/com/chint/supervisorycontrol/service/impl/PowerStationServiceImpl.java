package com.chint.supervisorycontrol.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.chint.supervisorycontrol.constants.ResponseConstants;
import com.chint.supervisorycontrol.constants.ResponseMessage;
import com.chint.supervisorycontrol.mapper.PowerStationMapper;
import com.chint.supervisorycontrol.model.PowerStationModel;
import com.chint.supervisorycontrol.service.PowerStationService;
import com.chint.supervisorycontrol.vo.powerStationVO.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author zhouying3
 */
@Service
@AllArgsConstructor
public class PowerStationServiceImpl implements PowerStationService {
    private final PowerStationMapper powerStationMapper;
    @Override
    public ResponseMessage<JSONObject> listPowerStationData(ListPowerStationDataVO vo) {
        return null;
    }

    @Override
    public ResponseMessage listPowerStations(ListPowerStationVO vo) {
        Integer pageNum = vo.getPageNum();
        Integer pageSize = vo.getPageSize();
        PageHelper.startPage(pageNum,pageSize);
        List<JSONObject> listPowerStation = powerStationMapper.listPowerStation(vo);
        return ResponseMessage.success(PageInfo.of(Optional.of(listPowerStation).orElse(new ArrayList<>())));
    }

    @Override
    public ResponseMessage<JSONObject> getPowerStationInfo(GetPowerStationInfoVO vo) {
        return null;
    }

    @Override
    public ResponseMessage<JSONObject> addPowerStation(AddPowerStationVO vo) {
        return null;
    }

    @Override
    public ResponseMessage getPowerStationStatistics(PowerStationStatisticsVO vo) {
        Long powerStationId = vo.getPowerStationId();
        PowerStationModel powerStation = powerStationMapper.selectByPrimaryKey(powerStationId);
        if (powerStation==null) {
            return ResponseMessage.fail(ResponseConstants.GET_FAIL_MESSAGE);
        }
        return ResponseMessage.success(ResponseConstants.GET_SUCCESS_MESSAGE,powerStation);
    }

    @Override
    public ResponseMessage<JSONObject> getPowerStationEquipment(PowerStationEquipmentVO vo) {
        return null;
    }

    @Override
    public ResponseMessage<JSONObject> exportPowerStationData(ExportPowerStationDataVO vo) {
        return null;
    }

    @Override
    public ResponseMessage removePowerStation(RemovePowerStationVO vo) {
        return null;
    }

    @Override
    public ResponseMessage<JSONObject> updatePowerStation(UpdatePowerStationVO vo) {
        return null;
    }
}
