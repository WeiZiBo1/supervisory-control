package com.chint.supervisorycontrol.enums;

import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhouying3
 * 搜索类型常量
 */

public enum SearchTypeEnum {
    /**
     * 邮箱
     */
    EMAIL(1, "email"),
    /**
     * 公司名
     */
    COMPANY_NAME(2, "companyName");

    private final int code;
    private final String title;

    SearchTypeEnum(int code, String title) {
        this.code = code;
        this.title = title;
    }

    public static String getTitleByCode(Integer code){
        for (SearchTypeEnum value : SearchTypeEnum.values()) {
            if (code.equals(value.code)) {
                return value.title;
            }
        }
        return "";
    }




    public static List<JSONObject> listSearchTypes() {
        List<JSONObject> listLogStatus = new ArrayList<>();
        for (SearchTypeEnum value : SearchTypeEnum.values()) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("code", value.code);
            jsonObject.put("title", value.title);
            listLogStatus.add(jsonObject);
        }
        return listLogStatus;
    }
}
