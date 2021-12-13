package com.chint.supervisorycontrol.service;

import com.alibaba.fastjson.JSONObject;
import com.chint.supervisorycontrol.constants.ResponseMessage;
import com.chint.supervisorycontrol.vo.loginVO.GetUserInfoByTokenVO;
import com.chint.supervisorycontrol.vo.loginVO.LoginVO;
import com.chint.supervisorycontrol.vo.loginVO.LogoutVO;
import com.chint.supervisorycontrol.vo.userVO.AddUserVO;
import com.chint.supervisorycontrol.vo.userVO.RemoveUserVO;
import com.chint.supervisorycontrol.vo.userVO.SearchUserVO;
import com.chint.supervisorycontrol.vo.userVO.UpdateUserVO;

/**
 * @author zhouying3
 */
public interface LoginService {
    /**
     * 登录
     * @param vo “用户名，密码”
     * @return Token，用户信息
     */
    ResponseMessage<JSONObject> login(LoginVO vo);

    /**
     * 登出
     * @param vo “token”
     * @return Token，用户信息
     */
    ResponseMessage logout(LogoutVO vo);


    /**
     * 根据Token获取用户信息
     * @param vo “token”
     * @return Token，用户信息
     */
    ResponseMessage<JSONObject> getUserInfoByToken(GetUserInfoByTokenVO vo);
}
