package com.chint.supervisorycontrol.vo.powerStationVO;

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
public class PowerStationEquipmentVO {
    /**
     * 电站ID
     */
    @ApiModelProperty(value = "电站ID",example = "1")
    private Long powerStationId;
}
