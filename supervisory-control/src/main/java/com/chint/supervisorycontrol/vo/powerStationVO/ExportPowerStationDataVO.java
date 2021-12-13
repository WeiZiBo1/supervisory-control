package com.chint.supervisorycontrol.vo.powerStationVO;

import com.chint.supervisorycontrol.vo.BaseVO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * @author zhouying3
 */
@Getter
@Setter
@ToString
public class ExportPowerStationDataVO extends BaseVO {
    /**
     * 电站ID
     * */
    @ApiModelProperty(value = "电站ID",example = "[1,2,3,4,5]")
    private List<Long> powerStationIds;
}
