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
public class AddHardwareVO {
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
     * 当前版本
     * */
    @ApiModelProperty(value = "当前版本",example = "KS3141")
    private String version;

    /**
     * 沙盒
     * */
    @ApiModelProperty(value = "沙盒",example = "1")
    private Integer sandbox;

    /**
     * 描述
     * */
    @ApiModelProperty(value = "描述",example = "随便写写")
    private String description;

    /**
     * 英文描述
     * */
    @ApiModelProperty(value = "英文描述",example = "随便写写")
    private String enDescription;

    /**
     * 固件文件
     * */
    @ApiModelProperty(value = "固件文件",example = "随便写写")
    private String hardwareFile;
}
