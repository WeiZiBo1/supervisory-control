package com.chint.supervisorycontrol.vo.authorizationVO;

import com.chint.supervisorycontrol.vo.BaseVO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

/**
 * @author zhouying3
 */
@Getter
@Setter
@ToString
public class ListAuthorizationVO extends BaseVO {
    @ApiModelProperty(value = "角色等级（超级伙伴角色，合作伙伴角色，最终用户角色）",example = "1")
    @NotNull(message = "角色等级不能为空")
    private Integer roleClass;
}
