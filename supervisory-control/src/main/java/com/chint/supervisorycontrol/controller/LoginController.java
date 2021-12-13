package com.chint.supervisorycontrol.controller;


import com.alibaba.fastjson.JSONObject;
import com.chint.supervisorycontrol.constants.ResponseMessage;
import com.chint.supervisorycontrol.service.LoginService;
import com.chint.supervisorycontrol.vo.loginVO.GetUserInfoByTokenVO;
import com.chint.supervisorycontrol.vo.loginVO.LoginVO;
import com.chint.supervisorycontrol.vo.loginVO.LogoutVO;
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
@RequestMapping("login-management")
@Api(value = "登录接口", tags = "登录接口")
@AllArgsConstructor
public class LoginController {
    private final LoginService loginService;

    /**
     * 用户登录
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ApiOperation(value = "用户登录", notes = "用户登录")
    public ResponseMessage<JSONObject> login(@RequestBody @Validated LoginVO vo, BindingResult result) {
        return loginService.login(vo);
    }

    /**
     * 用户登出
     */
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    @ApiOperation(value = "用户登出", notes = "用户登出")
    public ResponseMessage logout( @RequestBody @Validated LogoutVO vo) {
        return loginService.logout(vo);
    }

    /**
     * 用户登录
     */
    @RequestMapping(value = "/userInfo", method = RequestMethod.GET)
    @ApiOperation(value = "根据Token获取 用户信息", notes = "根据Token获取 用户信息")
    public ResponseMessage<JSONObject> getUserInfoByToken(GetUserInfoByTokenVO vo) {
        return loginService.getUserInfoByToken(vo);
    }
}
