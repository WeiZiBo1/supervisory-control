package com.chint.supervisorycontrol.vo.powerStationVO;

import com.chint.supervisorycontrol.vo.BasePageVO;
import com.chint.supervisorycontrol.vo.BaseVO;
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
public class ListPowerStationVO extends BasePageVO {
    /**
     * 超级伙伴ID
     * */
    @ApiModelProperty(value = "超级伙伴ID", example = "1")
    private Long superPartnerId;

    /**
     * 合作伙伴ID
     * */
    @ApiModelProperty(value = "合作伙伴ID", example = "1")
    private Long partnerId;

    /**
     * 最终用户ID
     * */
    @ApiModelProperty(value = "最终用户ID", example = "1")
    private Long finalUserId;

    /**
     * 平台类型
     * 1）本平台； 2)英甄
     * */
    @ApiModelProperty(value = "平台类型", example = "1")
    private Integer platformType;

    /**
     * 电站名
     * */
    @ApiModelProperty(value = "电站名", example = "搜索内容")
    private String powerStationName;



}
