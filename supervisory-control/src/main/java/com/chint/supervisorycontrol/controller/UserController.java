package com.chint.supervisorycontrol.controller;

import com.alibaba.fastjson.JSONObject;
import com.chint.supervisorycontrol.constants.ResponseMessage;
import com.chint.supervisorycontrol.service.UserService;
import com.chint.supervisorycontrol.vo.userVO.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhouying3
 */
@RestController
@RequestMapping("user-management")
@Api(value = "用户接口", tags = "用户接口")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    /**
     * 超级用户列表
     */
    @RequestMapping(value = "/userInfo/superPartner", method = RequestMethod.GET)
    @ApiOperation(value = "搜索超级用户列表", notes = "搜索超级用户列表")
    public ResponseMessage listSuperPartner(SearchSuperPartnerVO vo) {
        return userService.listSuperPartner(vo);
    }

    /**
     * 添加超级用户
     */
    @RequestMapping(value = "/superPartner", method = RequestMethod.POST)
    @ApiOperation(value = "添加超级用户", notes = "添加超级用户")
    public ResponseMessage addSuperPartner(@RequestBody @Validated AddSuperPartnerVO vo, BindingResult result) {
        return userService.addSuperPartner(vo);
    }

    /**
     * 更新超级用户
     */
    @RequestMapping(value = "/superPartner", method = RequestMethod.PUT)
    @ApiOperation(value = "更新超级用户", notes = "更新超级用户")
    public ResponseMessage updateSuperPartner(@RequestBody @Validated UpdateSuperPartnerVO vo, BindingResult result) {
        return userService.updateSuperPartner(vo);
    }

    /**
     * 删除超级用户
     */
    @RequestMapping(value = "/superPartner", method = RequestMethod.DELETE)
    @ApiOperation(value = "删除超级用户", notes = "删除超级用户")
    public ResponseMessage deleteSuperPartner(@Validated DeleteSuperPartnerVO vo, BindingResult result) {
        return userService.deleteSuperPartner(vo);
    }

    /**
     * 超级用户-子账号列表
     */
    @RequestMapping(value = "/superPartnerSubAccounts", method = RequestMethod.GET)
    @ApiOperation(value = "超级用户-子账号列表", notes = "超级用户-子账号列表")
    public ResponseMessage listSuperPartnerSubAccounts(SearchSuperPartnerSubAccountsVO vo) {
        return userService.listSuperPartnerSubAccounts(vo);
    }

    /**
     * 用户列表
     */
    @RequestMapping(value = "/userInfo", method = RequestMethod.GET)
    @ApiOperation(value = "用户列表", notes = "用户列表")
    public ResponseMessage listUsers(SearchUserVO vo) {
        return userService.listUsers(vo);
    }

    /**
     * 获取用户
     */
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    @ApiOperation(value = "获取用户", notes = "获取用户")
    public ResponseMessage getUser(@Validated GetUserVO vo, BindingResult result) {
        return userService.getUsers(vo);
    }

    /**
     * 添加用户
     */
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    @ApiOperation(value = "添加用户", notes = "添加用户")
    public ResponseMessage<JSONObject> addUser(@Validated @RequestBody AddUserVO vo) {
        return userService.addUser(vo);
    }

    /**
     * 删除用户
     */
    @RequestMapping(value = "/user", method = RequestMethod.DELETE)
    @ApiOperation(value = "删除用户", notes = "删除用户")
    public ResponseMessage<JSONObject> removeUser(RemoveUserVO vo) {
        return userService.removeUser(vo);
    }

    /**
     * 更新用户
     */
    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    @ApiOperation(value = "更新用户", notes = "更新用户")
    public ResponseMessage updateUser(UpdateUserVO vo) {
        return userService.updateUser(vo);
    }

    /**
     * 更改密码
     */
    @RequestMapping(value = "/password", method = RequestMethod.PUT)
    @ApiOperation(value = "更改密码", notes = "更改密码")
    public ResponseMessage updateUser(UpdateUserPasswordVO vo) {
        return userService.updateUser(vo);
    }

}
