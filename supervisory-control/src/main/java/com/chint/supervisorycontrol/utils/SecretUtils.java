package com.chint.supervisorycontrol.utils;

import com.chint.supervisorycontrol.constants.CommonConstants;
import org.springframework.util.DigestUtils;

/**
 * @author zhouying3
 */

public class SecretUtils {
    public static String encryptByMd5(String password){
        return DigestUtils.md5DigestAsHex((password + CommonConstants.MD5_SALT).getBytes());
    }
}
