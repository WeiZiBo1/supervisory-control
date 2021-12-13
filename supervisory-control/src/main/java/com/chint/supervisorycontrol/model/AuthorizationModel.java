package com.chint.supervisorycontrol.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * @author zhouying3
 * 用户信息
 */

@Getter
@Setter
@ToString
@Table(name = "supervisory_authorization")
public class AuthorizationModel {
    /**
     * 权限ID
     */
    @Id
    private Integer id;
    /**
     * 权限页面
     */
    @Column(name = "authorization_page")
    private String authorizationPage;
    /**
     * 字段说明
     */
    @Column(name = "authorization_detail")
    private String authorizationDetail;
    /**
     * 排序
     */
    @Column(name = "sort")
    private Integer sort;
    /**
     * 页面等级
     */
    @Column(name = "page_level")
    private Integer pageLevel;

    /**
     * 父级页面
     */
    @Column(name = "parent_id")
    private Integer parentId;

}
