package com.chint.supervisorycontrol.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.chint.supervisorycontrol.constants.ResponseConstants;
import com.chint.supervisorycontrol.constants.ResponseMessage;
import com.chint.supervisorycontrol.enums.GateWayStatusEnum;
import com.chint.supervisorycontrol.mapper.GatewayMapper;
import com.chint.supervisorycontrol.model.GatewayModel;
import com.chint.supervisorycontrol.service.GatewayService;
import com.chint.supervisorycontrol.vo.gatewayVO.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.AllArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.*;

/**
 * @author zhouying3
 */
@Service
@AllArgsConstructor
public class GatewayServiceImpl implements GatewayService {

    private final GatewayMapper gatewayMapper;

    @Override
    public ResponseMessage<JSONObject> listGatewayData(ListGatewayDataVO vo) {
        return null;
    }

    @Override
    public ResponseMessage listGatewayState() {
        JSONObject gatewayState = gatewayMapper.listGatewayState();
        List<GatewayStateVO> list=new ArrayList<>();
        Map<String,Object> map=new HashMap<>();
        GatewayStateVO zx=new GatewayStateVO(gatewayState.get("gatewayOffline").toString(),"离线");
        GatewayStateVO lx=new GatewayStateVO(gatewayState.get("gateway0nline").toString(),"在线");
        GatewayStateVO wjh=new GatewayStateVO(gatewayState.get("gatewayNotActive").toString(),"未激活");
        list.add(zx);
        list.add(lx);
        list.add(wjh);
        map.put("list",list);
        map.put("gatewayTotal",gatewayState.get("gatewayTotal").toString());
        return ResponseMessage.success(map);
    }

    @Override
    public ResponseMessage listGateways(ListGatewaysVO vo) {
        Integer pageNum = vo.getPageNum();
        Integer pageSize = vo.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<JSONObject> gateways = gatewayMapper.listGateways(vo);
        gateways.stream().forEach(gateway -> gateway.put("gatewayStatusTitle",GateWayStatusEnum.getTitleByCode(gateway.getInteger("gatewayStatus"))));
        return ResponseMessage.success(PageInfo.of(Optional.of(gateways).orElse(new ArrayList<>())));
    }

    @Override
    public ResponseMessage<JSONObject> addGateway(AddGatewaysVO vo) {
        return null;
    }

    @Override
    public ResponseMessage<JSONObject> updateGateway(UpdateGatewayVO vo) {
        return null;
    }

    @Override
    public ResponseMessage<JSONObject> updateGatewayName(UpdateGatewayNameVO vo) {
        Long gatewayId = vo.getGatewayId();
        String gatewayName = vo.getGatewayName();
        //验证新名称不重复
        Example gateWayExample = new Example(GatewayModel.class);
        gateWayExample.createCriteria().andEqualTo("gatewayName", gatewayName);
        List<GatewayModel> gatewayModels = gatewayMapper.selectByExample(gateWayExample);
        if (CollectionUtils.isNotEmpty(gatewayModels)) {
            return ResponseMessage.fail(ResponseConstants.DUPLICATE_NAME_MESSAGE);
        }
        GatewayModel gatewayModel = new GatewayModel();
        gatewayModel.setId(gatewayId);
        gatewayModel.setGatewayName(gatewayName);
        int i = gatewayMapper.updateByPrimaryKeySelective(gatewayModel);
        if (i == 1){
            return ResponseMessage.success(ResponseConstants.UPDATE_SUCCESS_MESSAGE);
        }
        return ResponseMessage.fail(ResponseConstants.UPDATE_FAIL_MESSAGE);
    }

    @Override
    public ResponseMessage<JSONObject> updateGatewayAllocation(UpdateGatewayAllocationVO vo) {
        Long gatewayId = vo.getGatewayId();
        Long powerStationId = vo.getPowerStationId();
        GatewayModel gatewayModel = new GatewayModel();
        gatewayModel.setId(gatewayId);
        gatewayModel.setPowerStationId(powerStationId);
        int i = gatewayMapper.updateByPrimaryKeySelective(gatewayModel);
        if (i == 1){
            return ResponseMessage.success(ResponseConstants.UPDATE_SUCCESS_MESSAGE);
        }
        return ResponseMessage.fail(ResponseConstants.UPDATE_FAIL_MESSAGE);
    }
}
