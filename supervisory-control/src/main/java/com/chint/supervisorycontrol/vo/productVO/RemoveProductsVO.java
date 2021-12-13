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
public class RemoveProductsVO {
    /**
     * 产品ID
     * */
    @ApiModelProperty(value = "产品ID", example = "1")
    private Long productId;
}
