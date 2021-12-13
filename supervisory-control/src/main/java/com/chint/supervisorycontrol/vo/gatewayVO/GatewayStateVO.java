package com.chint.supervisorycontrol.vo.gatewayVO;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *网关状态
 */
@Getter
@Setter
@ToString
public class GatewayStateVO {
    @ApiModelProperty(value = "值",example = "1")
    private String value;

    @ApiModelProperty(value = "名称",example = "在线")
    private String name;

    public GatewayStateVO(String value, String name) {
        this.value = value;
        this.name = name;
    }
}
