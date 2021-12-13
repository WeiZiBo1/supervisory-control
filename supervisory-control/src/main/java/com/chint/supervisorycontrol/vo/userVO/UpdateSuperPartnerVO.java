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
 * 超级用户更新VO
 */
@Getter
@Setter
@ToString
public class UpdateSuperPartnerVO extends BaseVO {
    /**
     *用户ID
     */
    @ApiModelProperty(value = "用户ID", example = "1")
    @NotNull(message = "用户ID不能为空")
    private Long id;
    /**
     *电子邮箱
     */
    @ApiModelProperty(value = "电子邮箱", example = "222@qq.com")
    @NotBlank(message = "电子邮箱不能为空")
    private String email;
    /**
     *公司名
     */
    @ApiModelProperty(value = "公司名", example = "XXX公司")
    @NotBlank(message = "公司名不能为空")
    private String companyName;
    /**
     *是否启用
     */
    @ApiModelProperty(value = "是否启用（1：启用， 0：禁用）", example = "1")
    @NotNull(message = "启用状态不能为空")
    private Integer using;
    /**
     *角色ID
     */
    @ApiModelProperty(value = "角色ID", example = "1")
    @NotNull(message = "角色ID不能为空")
    private Long roleId;
}
