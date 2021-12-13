package com.chint.supervisorycontrol.enums;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhouying3
 * 日志状态常量
 */

public enum LogStatusEnum {
    /**
     * 未确认
     */
    NOT_CONFIRM(0, "未确认"),
    /**
     * 已确认
     */
    CONFIRM(1, "已确认");

    private final int code;
    private final String title;

    LogStatusEnum(int code, String title) {
        this.code = code;
        this.title = title;
    }

    public static List<JSONObject> listLogStatus() {
        List<JSONObject> listLogStatus = new ArrayList<>();
        for (LogStatusEnum value : LogStatusEnum.values()) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("code", value.code);
            jsonObject.put("title", value.title);
            listLogStatus.add(jsonObject);
        }
        return listLogStatus;
    }
}
