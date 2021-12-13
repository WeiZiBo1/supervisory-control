package com.chint.supervisorycontrol.vo.roleVO;

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
public class RemoveRoleVO {
    @ApiModelProperty(value = "角色ID",example = "1")
    @NotNull(message = "角色ID不能为空")
    private Long roleId;
}
