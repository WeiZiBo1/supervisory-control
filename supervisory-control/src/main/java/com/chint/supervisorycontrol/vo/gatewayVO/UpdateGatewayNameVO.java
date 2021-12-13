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
public class UpdateGatewayNameVO {
    @ApiModelProperty(value = "网关id",example = "1")
    private Long gatewayId;
    @ApiModelProperty(value = "网关名称",example = "网关111")
    private String gatewayName;
}
