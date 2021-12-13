package com.chint.supervisorycontrol.vo.logVO;

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
public class ListLogVO {
    /**
     * 电站ID
     * */
    @ApiModelProperty(value = "电站ID", example = "1")
    private Long powerStationId;

    /**
     * 日志类型
     * 1）电站相关；2）网关相关；3）逆变器相关；4）固件相关；5）读写相关；6）账户相关
     * */
    @ApiModelProperty(value = "日志类型", example = "1")
    private Integer logType;

    /**
     * 日志状态
     * 0）未确认；1）已确认
     * */
    @ApiModelProperty(value = "日志状态", example = "1")
    private Integer logStatus;

    /**
     * 日志内容
     * */
    @ApiModelProperty(value = "日志内容", example = "1")
    private String logContent;
}
