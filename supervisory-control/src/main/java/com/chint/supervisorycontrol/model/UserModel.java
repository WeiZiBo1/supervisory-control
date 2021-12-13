package com.chint.supervisorycontrol.model;

import com.fasterxml.jackson.annotation.JsonFormat;
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
@Table(name = "supervisory_user")
public class UserModel {
    /**
     * 主键ID
     */
    @Id
    private Long id;

    /**
     * 角色ID
     */
    @Column(name = "role_id")
    private Long roleId;

    /**
     * 父级ID
     */
    @Column(name = "parent_id")
    private Long parentId;
    /**
     * 用户名
     */
    @Column(name = "user_name")
    private String userName;
    /**
     * 密码
     */
    @Column(name = "password")
    private String password;
    /**
     * 电子邮箱
     */
    @Column(name = "email")
    private String email;
    /**
     * 公司名
     */
    @Column(name = "company_name")
    private String companyName;
    /**
     * 账户启用状态；1)启用，0）禁用
     */
    @Column(name = "is_used")
    private Integer isUsed;
    /**
     * 用户类型；1）超级用户，2）合作伙伴，3）最终用户
     */
    @Column(name = "user_type")
    private Integer userType;

    /**
     * 账户类型：1）主账户，2）子账户
     */
    @Column(name = "account_type")
    private Integer accountType;

    /**
     * 超级伙伴ID
     */
    @Column(name = "super_partner_id")
    private Long superPartnerId;

    /**
     * 合作伙伴ID
     */
    @Column(name = "partner_id")
    private Long partnerId;

    /**
     * 最终用户ID
     */
    @Column(name = "final_user_id")
    private Long finalUserId;

    /**
     * 创建时间
     */
    @Column(name = "gmt_create")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime createTime;
    /**
     * 更新时间
     */
    @Column(name = "gmt_modified")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime updateTime;

   /**
     * 上一次登陆时间
     */
    @Column(name = "gmt_last_login")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime lastLoginTime;

    /**
     * 创建者ID
     */
    @Column(name = "create_user")
    private Long createUser;


    /**
     * 更新者ID
     */
    @Column(name = "update_user")
    private Long updateUser;
}
