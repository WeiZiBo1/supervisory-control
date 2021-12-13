package com.chint.supervisorycontrol.vo.userVO;

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
public class AddUserVO extends BaseVO {
    /**
     * 用户类型
     * 1）超级伙伴；2）合作伙伴；3）最终用户
     * */
    @ApiModelProperty(value = "用户类型", example = "1")
    @NotNull(message = "用户类型不能为空")
    private Integer userType;

    /**
     * 账号类型
     * 1）超级管理员；2）普通用户；
     */
    @ApiModelProperty(value = "账号类型", example = "1")
    private Integer accountType;

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
     * 权限<List>
     * */
    @ApiModelProperty(value = "权限<List>",example = "[1,2,3]")
    private List<Integer> authority;
    /**
     * 1）启用； 0）禁用
     * */
    @ApiModelProperty(value = "启用/禁用",example = "1")
    @NotNull(message = "账号启用状态 不能为空")
    private Integer using;
    /**
     * 超级用户ID
     * */
    @ApiModelProperty(value = "超级用户ID",example = "1")
    private Integer superPartnerId;

    /**
     * 合作伙伴ID
     * */
    @ApiModelProperty(value = "合作伙伴ID",example = "1")
    private Integer partnerId;

}
