package com.chint.supervisorycontrol.vo;

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
public class BasePageVO extends BaseVO{
    @ApiModelProperty(value = "页码",example = "1")
    private Integer pageNum;
    @ApiModelProperty(value = "行数",example = "10")
    private Integer pageSize;
    @ApiModelProperty(value = "总计",example = "100")
    private Integer total;
}
