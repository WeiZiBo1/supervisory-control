package com.chint.supervisorycontrol.vo.userVO;

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
public class RemoveUserVO extends BaseVO {
    @ApiModelProperty(value = "用户ID", example = "[1,2,3]")
    private List<Long> userIds;
}
