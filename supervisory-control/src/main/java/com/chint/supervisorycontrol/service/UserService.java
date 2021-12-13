package com.chint.supervisorycontrol.service;

import com.alibaba.fastjson.JSONObject;
import com.chint.supervisorycontrol.constants.ResponseMessage;
import com.chint.supervisorycontrol.model.UserModel;
import com.chint.supervisorycontrol.vo.userVO.*;

import java.util.List;
import java.util.Set;

/**
 * @author zhouying3
 */
public interface UserService {
    /**
     * 添加用户
     * @param vo “用户信息参数”
     * @return success
     */
    ResponseMessage<JSONObject> addUser(AddUserVO vo);

    /**
     * 用户列表
     * @param vo “用户列表参数”
     * @return success
     */
    ResponseMessage listUsers(SearchUserVO vo);

    /**
     * 删除用户
     * @param vo “删除用户参数”
     * @return success
     */
    ResponseMessage<JSONObject> removeUser(RemoveUserVO vo);

    /**
     * 删除用户
     * @param vo “更新用户参数”
     * @return success
     */
    ResponseMessage updateUser(UpdateUserVO vo);

    /**
     * 获取相关用户id
     * @param userId “用户id”;
     * @return success
     */
    Set<Long> getRelateUsers(Long userId);


    /**
     * 获取用户信息id
     * @param vo “用户id”;
     * @return success
     */
    ResponseMessage getUsers(GetUserVO vo);

    /**
     * 更改密码
     * @param vo “用户密码”;
     * @return success
     */
    ResponseMessage updateUser(UpdateUserPasswordVO vo);

    /**
     * 更改密码
     * @param vo “搜索类型；搜索内容”;
     * @return ResponseMessage
     */
    ResponseMessage listSuperPartner(SearchSuperPartnerVO vo);

    /**
     * 添加超级用户
     * @param vo “邮箱，密码，等”;
     * @return ResponseMessage
     */
    ResponseMessage addSuperPartner(AddSuperPartnerVO vo);

    /**
     * 更新超级用户
     * @param vo “邮箱，等”;
     * @return ResponseMessage
     */
    ResponseMessage updateSuperPartner(UpdateSuperPartnerVO vo);

    /**
     * 删除超级用户
     * @param vo “超级用户ID”;
     * @return ResponseMessage
     */
    ResponseMessage deleteSuperPartner(DeleteSuperPartnerVO vo);

    /**
     * 搜索超级用户子账号
     * @param vo 搜索类型，搜索内容
     * @return 子账户列表
     */
    ResponseMessage listSuperPartnerSubAccounts(SearchSuperPartnerSubAccountsVO vo);
}
