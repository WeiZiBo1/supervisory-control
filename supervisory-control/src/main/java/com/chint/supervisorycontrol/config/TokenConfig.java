package com.chint.supervisorycontrol.config;

import com.alibaba.fastjson.JSONObject;
import com.chint.supervisorycontrol.constants.CommonConstants;
import com.chint.supervisorycontrol.model.UserModel;
import com.chint.supervisorycontrol.service.UserService;
import com.chint.supervisorycontrol.utils.UUIDUtils;
import lombok.AllArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author zhouying3
 */
@AllArgsConstructor
@Component
public class TokenConfig {

    @Resource
    private final RedisTemplate redisTemplate;

    private final UserService userService;
    /**
     * 生成TOKEN，存储到Redis
     */
    public String createAccessTokenAndSave( UserModel userModel){
        String userName = userModel.getUserName();
        Long userId = userModel.getId();
        Integer userType = userModel.getUserType();
        Integer accountType = userModel.getAccountType();
        //时间戳
        long timeMillis = System.currentTimeMillis();
        //过期时间(300分钟)
        String token = UUIDUtils.generateToken(userName + timeMillis);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("userId", userId);
        jsonObject.put("userType", userType);
        jsonObject.put("accountType", accountType);
        redisTemplate.boundValueOps(token).set(jsonObject, CommonConstants.TOKEN_EXPIRE_TIME, TimeUnit.MINUTES);
        return token;
    }

    /**
     * 根据TOKEN，获取用户ID 和 下级关联ID
     */
    public JSONObject getUserIdByToken(String token){
        return  (JSONObject)redisTemplate.boundValueOps(token).get();
    }

}
