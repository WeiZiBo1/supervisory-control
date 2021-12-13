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
@Table(name = "supervisory_power_station")
@Getter
@Setter
public class PowerStationModel {
    @Id
    private Long id;

    @Column(name = "power_station_name")
    private Long powerStationName;

    @Column(name = "country")
    private Long country;

    @Column(name = "time_zone_id")
    private Long timeZoneId;

    @Column(name = "upload_time")
    private Long uploadTime;

    @Column(name = "power_station_location")
    private Long powerStationLocation;

    @Column(name = "power_station_type")
    private Long powerStationType;

    @Column(name = "parallel_type")
    private Long parallelType;

    @Column(name = "capacity")
    private Long capacity;

    @Column(name = "currency_unit")
    private Long currencyUnit;

    @Column(name = "electrovalency")
    private Long electrovalency;

    @Column(name = "temperature_unit")
    private Long temperatureUnit;

    @Column(name = "note")
    private Long note;

    @Column(name = "gateway_offline_alert")
    private Long gatewayOfflineAlert;

    @Column(name = "contacts")
    private Long contacts;

    @Column(name = "mobile_phone")
    private Long mobilePhone;

    @Column(name = "mail_address")
    private Long mailAddress;

    @Column(name = "gmt_create")
    private LocalDateTime gmtCreate;

    @Column(name = "gmt_modified")
    private LocalDateTime gmtModified;

}
