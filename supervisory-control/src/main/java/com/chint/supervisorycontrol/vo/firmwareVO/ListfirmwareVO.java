package com.chint.supervisorycontrol.vo.firmwareVO;

import com.chint.supervisorycontrol.vo.BasePageVO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;

/**
 * @author weizibo
 */
@Getter
@Setter
@ToString
public class ListfirmwareVO extends BasePageVO {
    /**
     * 型号id
     */
    @ApiModelProperty(value = "型号ID",example = "1")
    private Long firmwareModelId;
    /**
     * 产品id
     */
    @ApiModelProperty(value = "产品ID",example = "1")
    private Long firmwareProductId;
    /**
     * 模块名称
     */
    @ApiModelProperty(value = "模块名称",example = "1")
    private Long firmwareModularName;
    /**
     * 搜索内容
     */
    @ApiModelProperty(value = "搜索型号",example = "要搜什么")
    private String searchModel;
}
