package com.chint.supervisorycontrol.vo.hardwareVO;

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
public class ListHardwareVO {
    /**
     * 产品ID
     * */
    @ApiModelProperty(value = "产品ID",example = "1")
    private Long productId;

    /**
     * 型号ID
     * */
    @ApiModelProperty(value = "型号ID",example = "1")
    private Long modelId;

    /**
     * 模块ID
     * */
    @ApiModelProperty(value = "模块ID",example = "1")
    private Long moduleId;

    /**
     * 型号名称
     * */
    @ApiModelProperty(value = "型号名称",example = "DK131231")
    private String modelName;
}
