package com.chint.supervisorycontrol.vo.loginVO;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

/**
 * @author zhouying3
 */
@Getter
@Setter
@ToString
public class LoginVO {
    /**
     * 用户名
     */
    @Valid
    @ApiModelProperty(value = "用户名",example = "userName")
    @NotBlank(message = "用户名不能为空")
    private String userName;
    /**
     * 密码
     */
    @ApiModelProperty(value = "密码",example = "123456")
    @NotEmpty(message = "密码不能为空")
    private String password;
}
