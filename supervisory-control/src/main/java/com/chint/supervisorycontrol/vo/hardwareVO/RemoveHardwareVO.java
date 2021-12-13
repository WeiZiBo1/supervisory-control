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
public class RemoveHardwareVO {
    /**
     * 固件版本id
     * */
    @ApiModelProperty(value = "固件版本id",example = "1")
    private Long hardwareVersionId;
}
