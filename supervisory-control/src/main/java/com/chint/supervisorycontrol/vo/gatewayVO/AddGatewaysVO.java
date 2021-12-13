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
public class AddGatewaysVO {

    @ApiModelProperty(value = "电站ID",example = "1")
    private Long powerStationId;

    @ApiModelProperty(value = "网关序列号",example = "FX123254566")
    private String gatewaySeriesNumber;
}
