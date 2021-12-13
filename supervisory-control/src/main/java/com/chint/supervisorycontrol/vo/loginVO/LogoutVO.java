package com.chint.supervisorycontrol.vo.loginVO;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

/**
 * @author zhouying3
 */
@Getter
@Setter
@ToString
public class LogoutVO {
    /**
     * token
     */
    @ApiModelProperty(value = "token",example = "token")
    @NotBlank(message = "token不能为空")
    private String token;

}
