package com.chint.supervisorycontrol.vo.userVO;

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
public class SearchUserVO extends BasePageVO {
    /**
     * 搜索类型
     * 1）邮箱；2）公司名称
     */
    @ApiModelProperty(value = "搜索类型", example = "1")
    private Integer searchType;
    /**
     * 搜索内容
     */
    @ApiModelProperty(value = "搜索内容", example = "搜索内容")
    private String searchContent;

    /**
     * 超级用户ID
     */
    @ApiModelProperty(value = "超级用户ID", example = "1")
    private Long superPartnerId;

    /**
     * 最终用户ID
     */
    @ApiModelProperty(value = "用户ID", example = "1")
    private Long partnerId;
}
