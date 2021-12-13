package com.chint.supervisorycontrol.vo.gatewayVO;

import com.chint.supervisorycontrol.vo.BasePageVO;
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
public class ListGatewaysVO extends BasePageVO {
    @ApiModelProperty(value = "网关状态",example = "1")
    private Integer gatewayStatus;

    @ApiModelProperty(value = "网关型号",example = "1")
    private Integer gatewayModel;

    @ApiModelProperty(value = "网关版本号",example = "1")
    private Integer gatewayVersion;

//    @ApiModelProperty(value = "超级伙伴",example = "1")
//    private Long superPartnerId;
//
//    @ApiModelProperty(value = "合作伙伴",example = "1")
//    private Long partnerId;
//
//    @ApiModelProperty(value = "最终用户",example = "1")
//    private Long finalUserId;

    @ApiModelProperty(value = "搜索内容",example = "要搜什么")
    private String searchContent;

    @ApiModelProperty(value = "搜索类型",example = "1")
    private Integer searchType;

}
