package com.chint.supervisorycontrol.utils;

import java.util.UUID;

/**
 * @author zhouying3
 */
public class UUIDUtils {
    /**
     * 根据用户名，时间戳，生成TOKEN key
     * @param text 用户名，时间戳
     * @return TOKEN key
     */
    public static String generateToken(String text){
        return UUID.nameUUIDFromBytes(text.getBytes()).toString().replaceAll("-","");
    }
}
