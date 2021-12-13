package com.chint.supervisorycontrol.vo.loginVO;

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
public class GetUserInfoByTokenVO extends BaseVO {
    @ApiModelProperty(value = "TOKEN值", example = "token12345")
    private String token;
}
