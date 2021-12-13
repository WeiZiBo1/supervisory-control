package com.chint.supervisorycontrol.vo.roleVO;

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
public class ListOptionRolesVO extends BaseVO {
    /**
     * 角色层级
     * （1：超级用户层级，2：合作伙伴层级，3：最终用户层级）
     */
    @ApiModelProperty(value = "角色层级（1：超级用户层级，2：合作伙伴层级，3：最终用户层级）", example = "1")
    private Integer roleClass;
}
