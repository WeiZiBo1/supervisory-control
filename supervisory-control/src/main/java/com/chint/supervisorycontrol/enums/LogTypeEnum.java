package com.chint.supervisorycontrol.enums;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhouying3
 * 日志类型常量
 */

public enum LogTypeEnum {
    /**
     * 电站相关
     */
    POWER_STATION_LOG(1, "powerStationLog", "电站相关"),
    /**
     * 网关相关
     */
    GATEWAY_LOG(2, "gatewayLog", "网关相关"),
    /**
     * 逆变器相关
     */
    INVERTER_LOG(3, "inverterLog", "逆变器相关"),
    /**
     * 固件相关
     */
    HARDWARE_LOG(4, "hardwareLog", "固件相关"),
    /**
     * 读写相关
     */
    IO_LOG(5, "IOLog", "读写相关"),
    /**
     * 账户相关
     */
    ACCOUNT_LOG(6, "accountLog", "账户相关"),
    /**
     * 气象站相关
     */
    WEATHER_LOG(6, "weatherLog", "账户相关"),
    /**
     * 电表相关
     */
    ELECTRICITY_LOG(6, "electricityLog", "账户相关");

    private final int code;
    private final String name;
    private final String title;

    LogTypeEnum(int code, String name, String title) {
        this.code = code;
        this.name = name;
        this.title = title;
    }

    public static List<JSONObject> listLogTypes() {
        List<JSONObject> listLogTypes = new ArrayList<>();
        for (LogTypeEnum value : LogTypeEnum.values()) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("code", value.code);
            jsonObject.put("name", value.name);
            jsonObject.put("title", value.title);
            listLogTypes.add(jsonObject);
        }
        return listLogTypes;
    }
}
