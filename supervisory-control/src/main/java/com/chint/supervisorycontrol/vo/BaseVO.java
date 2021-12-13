package com.chint.supervisorycontrol.vo;

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
public class BaseVO {
    /**
     * 用户Id
     */
    @ApiModelProperty(value = "用户Id",example = "1",hidden = true)
    private Long userId;

    /**
     * 用户类型
     */
    @ApiModelProperty(value = "用户类型",example = "1",hidden = true)
    private Integer userType;
    /**
     * 账号类型
     * 1）超级管理员；2）普通用户；
     */
    @ApiModelProperty(value = "账号类型", example = "1",hidden = true)
    private Integer accountType;
    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名",example = "1",hidden = true)
    private String userName;
    /**
     * 密码
     */
    @ApiModelProperty(value = "密码",example = "123456",hidden = true)
    private String password;

    /**
     * 关联ID
     */
    @ApiModelProperty(value = "relatedId",example = "[1,2,3]",hidden = true)
    private List<Long> relatedIds;
}
