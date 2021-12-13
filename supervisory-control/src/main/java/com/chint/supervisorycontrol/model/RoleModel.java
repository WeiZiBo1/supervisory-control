package com.chint.supervisorycontrol.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * 角色Model
 * @author zhouying3
 */
@Getter
@Setter
@ToString
@Table(name = "supervisory_role")
public class RoleModel {
    /**
     * 角色主键ID
     */
    @Id
    private Long id;
    /**
     * 角色名称
     */
    @Column(name = "role_name")
    private String roleName;
    /**
     * 角色说明
     */
    @Column(name = "role_instruction")
    private String roleInstruction;
    /**
     * 创建者
     */
    @Column(name = "create_by")
    private Long createBy;
    /**
     * 创建时间
     */
    @Column(name = "gmt_create")
    private LocalDateTime gmtCreate;
    /**
     * 更新时间
     */
    @Column(name = "gmt_modified")
    private LocalDateTime gmtModified;
    /**
     * 启用：1  禁用：0
     */
    @Column(name = "is_used")
    private Integer isUsed;
    /**
     * 角色层级（1：超级用户层级，2：合作伙伴层级，3：最终用户层级）
     */
    @Column(name = "role_class")
    private Integer roleClass;

}
