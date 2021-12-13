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
public class GetHardwareVO {
    /**
     * 固件ID
     * */
    @ApiModelProperty(value = "固件ID",example = "1")
    private Long hardwareId;
}
