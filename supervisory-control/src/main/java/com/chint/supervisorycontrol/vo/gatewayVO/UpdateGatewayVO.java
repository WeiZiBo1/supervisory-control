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
public class UpdateGatewayVO {
    @ApiModelProperty(value = "电站ID",example = "1")
    private Long powerStationId;

    @ApiModelProperty(value = "网关名称",example = "网关名称")
    private String gatewayName;

}
