package com.chint.supervisorycontrol.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * @author weizibo
 * 固件信息
 */

@Getter
@Setter
@ToString
@Table(name = "supervisory_firmware")
public class FirmwareModel {
    /**
     * 主键ID
     */
    @Id
    private Long id;
    /**
     * 型号ID
     */
    @Column(name = "firmware_model_id")
    private Long firmwareModelId;
    /**
     * 产品ID
     */
    @Column(name = "firmware_product_id")
    private Long firmwareProductId;
    /**
     * 模块名称
     */
    @Column(name = "firmware_modular_name")
    private String firmwareModularName;
    /**
     * 固件版本
     */
    @Column(name = "firmware_version")
    private String firmwareVersion;
    /**
     * 升级版本
     */
    @Column(name = "upgrade_parameters")
    private String upgradeParameters;
    /**
     * 固件描述
     */
    @Column(name = "firmware_describe")
    private String firmwareDescribe;
    /**
     * 英文描述
     */
    @Column(name = "firmware_english_describe")
    private String firmwareEnglishDescribe;
    /**
     * 上传时间
     */
    @Column(name = "gmt_create")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime createTime;
}
