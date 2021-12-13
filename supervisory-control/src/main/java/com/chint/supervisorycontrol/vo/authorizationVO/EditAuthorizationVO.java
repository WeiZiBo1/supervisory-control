package com.chint.supervisorycontrol.vo.authorizationVO;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * @author zhouying3
 */
@Getter
@Setter
@ToString
public class EditAuthorizationVO {
    @ApiModelProperty(value = "用户ID", example = "1")
    private Long userId;

    /**
     * 授权项
     */
    @ApiModelProperty(value = "授权项",example = "[1,2,3]")
    private List<Integer> authorizationList;
}
