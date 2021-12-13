package com.chint.supervisorycontrol.vo.downloadVO;

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
public class PowerStationDownloadVO extends BasePageVO {
    /**
     * 超级伙伴ID
     */
    @ApiModelProperty(value = "超级伙伴ID",example = "1")
    private Long superPartnerId;
    /**
     * 合作伙伴ID
     */
    @ApiModelProperty(value = "合作伙伴ID",example = "1")
    private Long partnerId;
    /**
     * 最终用户ID
     */
    @ApiModelProperty(value = "最终用户ID",example = "1")
    private Long finalUserId;

    /**
     * 电站名称
     */
    @ApiModelProperty(value = "电站名称",example = "电站名称")
    private String powerStationName;


}
