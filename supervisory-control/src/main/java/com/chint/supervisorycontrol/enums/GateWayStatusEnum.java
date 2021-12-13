package com.chint.supervisorycontrol.enums;

import com.alibaba.fastjson.JSONObject;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhouying3
 * 网关状态常量
 */
@Getter
public enum GateWayStatusEnum {
    /**
     * 离线
     */
    OFFLINE(0, "离线"),
    /**
     * 在线
     */
    ONLINE(1, "在线");

    private final int code;
    private final String title;

    GateWayStatusEnum(int code, String title) {
        this.code = code;
        this.title = title;
    }

    public static String getTitleByCode(Integer code){
        for (GateWayStatusEnum value : GateWayStatusEnum.values()) {
            if (code.equals(value.code)) {
                return value.title;
            }
        }
        return "";
    }

    public static List<JSONObject> listUsingStatus() {
        List<JSONObject> listLogStatus = new ArrayList<>();
        for (GateWayStatusEnum value : GateWayStatusEnum.values()) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("code", value.code);
            jsonObject.put("title", value.title);
            listLogStatus.add(jsonObject);
        }
        return listLogStatus;
    }
}
