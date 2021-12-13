package com.chint.supervisorycontrol.vo.productVO;

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
public class ListProductsVO {
    /**
     * 产品序列号
     * */
    @ApiModelProperty(value = "产品序列号", example = "FD231231")
    private String productSeriesNumber;
}
