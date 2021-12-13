package com.chint.supervisorycontrol.vo.userVO;

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
public class SearchSuperPartnerSubAccountsVO extends BasePageVO {
    /**
     * 搜索类型
     */
    @ApiModelProperty(value = "搜索类型", example = "1")
    private Integer searchType;
    /**
     * 搜索内容
     */
    @ApiModelProperty(value = "搜索内容", example = "搜索内容")
    private String searchContent;
}
