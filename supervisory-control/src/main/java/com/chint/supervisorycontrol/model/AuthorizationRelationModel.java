package com.chint.supervisorycontrol.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * @author zhouying3
 */
@Table(name = "supervisory_role_authorization_relation")
@Getter
@Setter
public class AuthorizationRelationModel {
    @Id
    private Long id;
    @Column(name = "role_id")
    private Long roleId;
    @Column(name = "authorization_id")
    private Integer authorizationId;
    @Column(name = "gmt_create")
    private LocalDateTime gmtCreate;
}
