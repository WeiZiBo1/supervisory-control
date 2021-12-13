package com.chint.supervisorycontrol.mapper;

import com.alibaba.fastjson.JSONObject;
import com.chint.supervisorycontrol.model.PowerStationModel;
import com.chint.supervisorycontrol.vo.gatewayVO.ListGatewaysVO;
import com.chint.supervisorycontrol.vo.powerStationVO.ListPowerStationVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zhouying3
 */
@Repository
@Mapper
public interface PowerStationMapper extends BaseMapper<PowerStationModel>{
    /**
     * 网关中心列表-分页
     * @param ListGatewaysVO
     * @return
     */
    List<JSONObject> listPowerStation(ListPowerStationVO vo);
}
