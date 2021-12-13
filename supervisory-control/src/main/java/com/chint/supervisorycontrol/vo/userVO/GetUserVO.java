package com.chint.supervisorycontrol.vo.userVO;

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
public class GetUserVO {
    @ApiModelProperty(value = "用户ID",example = "1")
    @NotNull(message = "用户ID不能为空")
    private Long userId;
}
