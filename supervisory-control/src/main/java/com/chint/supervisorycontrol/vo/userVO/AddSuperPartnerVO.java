package com.chint.supervisorycontrol.vo.userVO;

import com.chint.supervisorycontrol.vo.BaseVO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author zhouying3
 * 新建超级用户 VO
 */
@Getter
@Setter
@ToString
public class AddSuperPartnerVO extends BaseVO {
    /**
     * 公司名称
     * */
    @ApiModelProperty(value = "公司名称",example = "XXX有限公司")
    @NotBlank(message = "公司名称不能为空")
    private String companyName;
    /**
     * 邮箱
     * */
    @ApiModelProperty(value = "邮箱",example = "xxx@hotmail.com")
    @NotBlank(message = "邮箱不能为空")
    private String email;
    /**
     * 密码
     * */
    @ApiModelProperty(value = "密码",example = "pass")
    @NotBlank(message = "密码不能为空")
    private String password;
    /**
     * 1）启用； 0）禁用
     * */
    @ApiModelProperty(value = "启用/禁用",example = "1")
    @NotNull(message = "账号启用状态不能为空")
    private Integer using;

    /**
     * 角色ID
     * */
    @ApiModelProperty(value = "角色ID",example = "1")
    @NotNull(message = "角色ID不能为空")
    private Long roleId;
}
