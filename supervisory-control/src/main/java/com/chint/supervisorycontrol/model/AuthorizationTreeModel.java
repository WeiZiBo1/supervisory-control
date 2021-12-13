package com.chint.supervisorycontrol.model;

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
public class AuthorizationTreeModel {
    /**
     * 权限id
     */
    private Integer id;
    /**
     * 权限名称
     */
    private String name;
    /**
     * 父级id
     */
    private Integer parentId;

    /**
     * 子id集合
     */
    private List<AuthorizationTreeModel> childModelList;
}
