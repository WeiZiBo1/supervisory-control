package com.chint.supervisorycontrol.enums;

import com.alibaba.fastjson.JSONObject;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author zhouying3
 * 用户账号状态常量
 */
@Getter
public enum RoleClassEnum {
    /**
     * 超级用户--角色
     */
    SUPER_PARTNER_ROLE(1, "超级用户角色", Collections.singletonList(20)),
    /**
     * 超级用户--角色
     */
    SUPER_PARTNER_SUB_ROLE(2, "超级用户---子用户角色", Arrays.asList(6,27)),
    /**
     * 合作伙伴--子角色
     */
    PARTNER_ROLE(3, "合作伙伴角色", Arrays.asList(6,30)),
    /**
     * 合作伙伴--子角色
     */
    PARTNER_SUB_ROLE(4, "合作伙伴---子用户角色", Arrays.asList(6,7,27)),
    /**
     * 最终用户--角色
     */
    FINAL_USER_ROLE(5, "最终用户角色", Arrays.asList(6,7,43)),
    /**
     * 最终用户--子角色
     */
    FINAL_USER_SUB_ROLE(6, "最终用户---子用户角色", Collections.singletonList(2));

    private final int code;
    private final String title;
    private final List<Integer> banList;

    RoleClassEnum(int code, String title, List<Integer> banList) {
        this.code = code;
        this.title = title;
        this.banList = banList;
    }

    public static String getTitleByCode(Integer code){
        for (RoleClassEnum value : RoleClassEnum.values()) {
            if (code.equals(value.code)) {
                return value.title;
            }
        }
        return "";
    }

    public static List<Integer> getBanListByCode(Integer code){
        for (RoleClassEnum value : RoleClassEnum.values()) {
            if (code.equals(value.code)) {
                return value.banList;
            }
        }
        return new ArrayList<>();
    }

    public static List<JSONObject> listRoleClassEnum(Integer userType) {
        List<JSONObject> listLogStatus = new ArrayList<>();
        for (RoleClassEnum value : RoleClassEnum.values()) {
            JSONObject jsonObject = new JSONObject();
            if (UserTypeEnum.SUPER_PARTNER.getCode().equals(userType)) {
                if (value.code<2){
                    continue;
                }
            }
            if (UserTypeEnum.PARTNER.getCode().equals(userType)) {
                if (value.code<4){
                    continue;
                }
            }
            if (UserTypeEnum.FINAL_USER.getCode().equals(userType)) {
                if (value.code<6){
                    continue;
                }
            }
            jsonObject.put("code", value.code);
            jsonObject.put("title", value.title);
            listLogStatus.add(jsonObject);
        }
        return listLogStatus;
    }
}
