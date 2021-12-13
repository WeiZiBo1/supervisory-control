package com.chint.supervisorycontrol.mapper;

import com.chint.supervisorycontrol.model.GatewayModel;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author weizibo
 */
@Repository
@Mapper
public interface FirmwareMapper extends BaseMapper<GatewayModel>{

}
