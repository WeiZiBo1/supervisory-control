package com.chint.supervisorycontrol.mapper;

import com.alibaba.fastjson.JSONObject;
import com.chint.supervisorycontrol.model.GatewayModel;
import com.chint.supervisorycontrol.vo.gatewayVO.ListGatewaysVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zhouying3
 */
@Repository
@Mapper
public interface GatewayMapper extends BaseMapper<GatewayModel>{

    /**
     * 网关中心列表-分页
     * @param ListGatewaysVO
     * @return
     */
    List<JSONObject> listGateways(ListGatewaysVO vo);
    /**
     * 网关状态百分比
     * @return
     */
    JSONObject listGatewayState();
}
