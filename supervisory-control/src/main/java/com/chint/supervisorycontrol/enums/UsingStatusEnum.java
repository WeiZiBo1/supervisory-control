package com.chint.supervisorycontrol.enums;

import com.alibaba.fastjson.JSONObject;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhouying3
 * 用户账号状态常量
 */
@Getter
public enum UsingStatusEnum {
    /**
     * 未确认
     */
    INACTIVE(0, "禁用"),
    /**
     * 已确认
     */
    ACTIVE(1, "启用");

    private final int code;
    private final String title;

    UsingStatusEnum(int code, String title) {
        this.code = code;
        this.title = title;
    }

    public static String getTitleByCode(Integer code){
        for (UsingStatusEnum value : UsingStatusEnum.values()) {
            if (code.equals(value.code)) {
                return value.title;
            }
        }
        return "";
    }

    public static List<JSONObject> listUsingStatus() {
        List<JSONObject> listLogStatus = new ArrayList<>();
        for (UsingStatusEnum value : UsingStatusEnum.values()) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("code", value.code);
            jsonObject.put("title", value.title);
            listLogStatus.add(jsonObject);
        }
        return listLogStatus;
    }
}
