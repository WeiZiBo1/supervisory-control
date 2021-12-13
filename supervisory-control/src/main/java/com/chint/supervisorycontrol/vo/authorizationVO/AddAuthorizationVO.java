package com.chint.supervisorycontrol.vo.authorizationVO;

import com.chint.supervisorycontrol.vo.BaseVO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * @author zhouying3
 */
@Getter
@Setter
@ToString
public class AddAuthorizationVO extends BaseVO {
    /**
     * 授权项
     */
    @ApiModelProperty(value = "授权项",example = "[1,2,3]")
    private List<Integer> authorizationList;
}
