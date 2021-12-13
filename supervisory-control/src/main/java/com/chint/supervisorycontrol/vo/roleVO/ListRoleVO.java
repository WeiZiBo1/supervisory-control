package com.chint.supervisorycontrol.vo.roleVO;

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
public class ListRoleVO extends BasePageVO {
    @ApiModelProperty(value = "角色名称",example = "普通超级伙伴")
    private String roleName;
}
