package com.chint.supervisorycontrol.enums;

import com.alibaba.fastjson.JSONObject;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhouying3
 * 用户类型常量
 */
@Getter
public enum UserTypeEnum {
    /**
     * 超级管理员
     */
    ADMINISTRATOR(0, "administrator", "超级管理员"),
    /**
     * 超级用户
     */
    SUPER_PARTNER(1, "super_partner", "超级用户"),
    /**
     * 合奏伙伴
     */
    PARTNER(2, "partner", "合奏伙伴"),
    /**
     * 最终用户
     */
    FINAL_USER(3, "final_user", "最终用户");

    private final Integer code;
    private final String name;
    private final String title;

    UserTypeEnum(int code, String name, String title) {
        this.code = code;
        this.name = name;
        this.title = title;
    }

    public static String getTitleByCode(Integer code){
        for (UserTypeEnum value : UserTypeEnum.values()) {
            if (code.equals(value.code)) {
                return value.title;
            }
        }
        return "";
    }

    public static List<JSONObject> listUserTypes() {
        List<JSONObject> listUserTypes = new ArrayList<>();
        for (UserTypeEnum value : UserTypeEnum.values()) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("code", value.code);
            jsonObject.put("name", value.name);
            jsonObject.put("title", value.title);
            listUserTypes.add(jsonObject);
        }
        return listUserTypes;
    }
}
