package com.chint.supervisorycontrol.vo.powerStationVO;

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
public class AddPowerStationVO extends BaseVO {
    /**
     * 电站名称
     * */
    @ApiModelProperty(value = "电站名称", example = "XXX电站")
    private String powerStationName;

    /**
     * 电站地址
     * */
    @ApiModelProperty(value = "电站地址", example = "XXX市XXX区XXX路")
    private String powerStationAddress;

    /**
     * 安装时间
     * */
    @ApiModelProperty(value = "安装时间", example = "2021/1/1 19：30:32")
    private String powerStationBuildTime;

    /**
     * 上传间隔
     * */
    @ApiModelProperty(value = "上传间隔", example = "5")
    private Integer powerStationUploadTime;

    /**
     * 时区
     * */
    @ApiModelProperty(value = "时区", example = "(UTC+08:00)北京，重庆，香港特别行政区，乌鲁木齐")
    private String powerStationTimeZone;

    /**
     * 电站图片
     * */
    @ApiModelProperty(value = "电站图片", example = "url=XXXXX")
    private String powerStationImage;
}
