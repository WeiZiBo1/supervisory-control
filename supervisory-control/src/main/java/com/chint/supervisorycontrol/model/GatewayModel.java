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
 * 网关信息
 */

@Getter
@Setter
@ToString
@Table(name = "supervisory_gateway")
public class GatewayModel {
    /**
     * 主键ID
     */
    @Id
    private Long id;
    /**
     * 电站ID
     */
    @Column(name = "power_station_id")
    private Long powerStationId;
    /**
     * 网关名称
     */
    @Column(name = "gateway_name")
    private String gatewayName;
    /**
     * 网关状态（0：离线，1：在线）
     */
    @Column(name = "gateway_status")
    private Integer gatewayStatus;
    /**
     * 状态（0：禁用，1：启用）
     */
    @Column(name = "state")
    private Integer state;
    /**
     * 转发（0：否，1：是）
     */
    @Column(name = "gateway_forward")
    private Integer gatewayForward;
    /**
     * 激活状态（0：未激活，1：已激活）
     */
    @Column(name = "gateway_active_state")
    private Integer gatewayActiveState;
    /**
     * mac地址
     */
    @Column(name = "mac_address")
    private String macAddress;
    /**
     * 网关型号
     */
    @Column(name = "gateway_model")
    private Integer gatewayModel;
    /**
     * 固件版本
     */
    @Column(name = "hardware_version")
    private Integer hardwareVersion;
    /**
     * 网关序列号
     */
    @Column(name = "gateway_serial_number")
    private String gatewaySerialNumber;
    /**
     * 信号强度
     */
    @Column(name = "signal_strength")
    private Integer signalStrength;
    /**
     * 创建时间
     */
    @Column(name = "gmt_create")
    private LocalDateTime gmtCreate;
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
     * 被更新时间
     */
    @Column(name = "gmt_modified")
    private LocalDateTime gmtModified;
    /**
     * 批次号
     */
    @Column(name = "batch_number")
    private String batchNumber;
}
