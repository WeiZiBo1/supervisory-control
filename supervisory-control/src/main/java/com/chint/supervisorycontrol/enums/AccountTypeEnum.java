package com.chint.supervisorycontrol.enums;

import com.alibaba.fastjson.JSONObject;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhouying3
 * 用户类型常量
 */
@Getter
public enum AccountTypeEnum {
    /**
     * 超级用户
     */
    MAIN_ACCOUNT(1, "main_account", "主账户"),
    /**
     * 最终用户
     */
    SUB_ACCOUNT(2, "sub_account", "子账户");

    private final Integer code;
    private final String name;
    private final String title;

    AccountTypeEnum(Integer code, String name, String title) {
        this.code = code;
        this.name = name;
        this.title = title;
    }

    public static String getTitleByCode(Integer code){
        for (AccountTypeEnum value : AccountTypeEnum.values()) {
            if (code.equals(value.code)) {
                return value.title;
            }
        }
        return "";
    }

    public static List<JSONObject> listAccountTypes() {
        List<JSONObject> listUserTypes = new ArrayList<>();
        for (AccountTypeEnum value : AccountTypeEnum.values()) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("code", value.code);
            jsonObject.put("name", value.name);
            jsonObject.put("title", value.title);
            listUserTypes.add(jsonObject);
        }
        return listUserTypes;
    }
}
