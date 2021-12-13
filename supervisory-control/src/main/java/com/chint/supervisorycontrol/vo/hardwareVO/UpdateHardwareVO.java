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
public class UpdateHardwareVO {
    /**
     * 版本号
     * */
    @ApiModelProperty(value = "版本号",example = "KS3141")
    private String version;
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

}
