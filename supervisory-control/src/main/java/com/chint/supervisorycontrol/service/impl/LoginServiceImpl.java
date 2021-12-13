package com.chint.supervisorycontrol.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.chint.supervisorycontrol.config.TokenConfig;
import com.chint.supervisorycontrol.constants.CommonConstants;
import com.chint.supervisorycontrol.constants.ResponseConstants;
import com.chint.supervisorycontrol.constants.ResponseMessage;
import com.chint.supervisorycontrol.enums.AccountTypeEnum;
import com.chint.supervisorycontrol.enums.UserTypeEnum;
import com.chint.supervisorycontrol.enums.UsingStatusEnum;
import com.chint.supervisorycontrol.mapper.UserMapper;
import com.chint.supervisorycontrol.model.UserModel;
import com.chint.supervisorycontrol.service.AuthorizationService;
import com.chint.supervisorycontrol.service.LoginService;
import com.chint.supervisorycontrol.service.UserService;
import com.chint.supervisorycontrol.utils.SecretUtils;
import com.chint.supervisorycontrol.vo.loginVO.GetUserInfoByTokenVO;
import com.chint.supervisorycontrol.vo.loginVO.LoginVO;
import com.chint.supervisorycontrol.vo.loginVO.LogoutVO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author zhouying3
 */
@Service
@AllArgsConstructor
@Slf4j
public class LoginServiceImpl implements LoginService {
    private final UserMapper userMapper;
    private final TokenConfig tokenConfig;
    private final RedisTemplate redisTemplate;
    private final AuthorizationService authorizationService;
    private final UserService userService;

    @Override
    public ResponseMessage<JSONObject> login(LoginVO vo) {
        String userName = vo.getUserName();
        String password = SecretUtils.encryptByMd5(vo.getPassword());
        Example example = new Example(UserModel.class);
        example.createCriteria()
                .andEqualTo("userName", userName)
                .andEqualTo("password", password)
                .andNotEqualTo("isUsed", UsingStatusEnum.INACTIVE.getCode());
        UserModel userModel = userMapper.selectOneByExample(example);
        if (userModel==null) {
            return ResponseMessage.fail(ResponseConstants.INCORRECT_USERNAME_OR_PASSWORD_MESSAGE);
        }
        //生成token,存入redis，并返回Token
        String accessToken = tokenConfig.createAccessTokenAndSave(userModel);
        //日志
        log.info(CommonConstants.TOKEN_HEADER_VALUE+accessToken);
        //封装返回
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(CommonConstants.TOKEN_HEADER_VALUE, accessToken);
        jsonObject.put("userName", userModel.getUserName());
        return ResponseMessage.success(jsonObject);
    }

    @Override
    public ResponseMessage logout(LogoutVO vo) {
        String token = vo.getToken();
        Boolean delete = redisTemplate.delete(token);
        return ResponseMessage.success(ResponseConstants.DELETE_SUCCESS_MESSAGE);
    }

    @Override
    public ResponseMessage<JSONObject> getUserInfoByToken(GetUserInfoByTokenVO vo) {
        String token = vo.getToken();
        JSONObject userIdByToken = tokenConfig.getUserIdByToken(token);
        Long userId = userIdByToken.getLongValue("userId");
        if (userId==null) {
            return ResponseMessage.fail(ResponseConstants.INCORRECT_TOKEN_MESSAGE);
        }
        UserModel userModel = userMapper.selectByPrimaryKey(userId);
        if (userModel==null) {
            return ResponseMessage.fail(ResponseConstants.INCORRECT_TOKEN_MESSAGE);
        }
        Integer userType = userModel.getUserType();
        Integer accountType = userModel.getAccountType();
        Long roleId = userModel.getRoleId();
        //获取页面权限列表
        List<Integer> authorizationList = authorizationService.listAuthorizationUrl(roleId);
        //获取 关联用户
//        Set<Long> relateUsers = userService.getRelateUsers(userModel);
        //返回
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("userType", userType);
        jsonObject.put("accountType", accountType);
        jsonObject.put("accountTypeTitle", AccountTypeEnum.getTitleByCode(accountType));
        jsonObject.put("authorizationList", authorizationList);
        jsonObject.put("userName", userModel.getUserName());
        jsonObject.put("userId", userId);
        jsonObject.put("userTypeTitle", UserTypeEnum.getTitleByCode(userType));
//        jsonObject.put("relateUsers", relateUsers);
        return ResponseMessage.success(jsonObject);
    }
}
