package com.chint.supervisorycontrol.vo.roleVO;

import com.chint.supervisorycontrol.vo.BaseVO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author zhouying3
 */
@Getter
@Setter
@ToString
public class AddRoleVO extends BaseVO {
    /**
     * 角色名称
     */
    @ApiModelProperty(value = "角色名称", example = "角色名称")
    @NotBlank(message = "角色名称不能为空")
    private String roleName;
    /**
     * 角色层级
     */
    @ApiModelProperty(value = "角色层级", example = "1")
    @NotNull(message = "角色层级不能为空")
    private Integer roleClass;

    /**
     * 角色状态  1）启用/0）禁用
     */
    @ApiModelProperty(value = "角色状态  1）启用/0）禁用", example = "1")
    private Integer isUsed;

    /**
     * 角色描述
     */
    @ApiModelProperty(value = "角色描述", example = "角色描述")
    private String roleDescription;
    /**
     * 权限ID 集合
     */
    @ApiModelProperty(value = "权限ID 集合", example = "[1,2,3]")
    private List<Integer> authorizationList;
}
