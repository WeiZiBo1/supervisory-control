package com.chint.supervisorycontrol.vo.gatewayVO;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author zhouying3
 */
@Getter
@Setter
@ToString
public class UpdateGatewayAllocationVO {
    @ApiModelProperty(value = "网关id",example = "1")
    private Long gatewayId;
    @ApiModelProperty(value = "电站ID",example = "1")
    private Long powerStationId;
}
