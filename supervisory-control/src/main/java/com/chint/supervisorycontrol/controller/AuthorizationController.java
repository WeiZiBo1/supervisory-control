package com.chint.supervisorycontrol.controller;

import com.alibaba.fastjson.JSONObject;
import com.chint.supervisorycontrol.constants.ResponseMessage;
import com.chint.supervisorycontrol.service.AuthorizationService;
import com.chint.supervisorycontrol.vo.authorizationVO.EditAuthorizationVO;
import com.chint.supervisorycontrol.vo.authorizationVO.ListAuthorizationVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zhouying3
 */
@RestController
@RequestMapping("/authorization-management")
@Api(value = "权限接口", tags = "权限接口")
@AllArgsConstructor
public class AuthorizationController {
    private final AuthorizationService authorizationService;
    /**
     * 权限列表
     */
    @RequestMapping(value = "/authorizationInfo", method = RequestMethod.GET)
    @ApiOperation(value = "权限列表", notes = "权限列表")
    public ResponseMessage listAuthorization(@Validated ListAuthorizationVO vo, BindingResult result) {
        return authorizationService.listAuthorization(vo);
    }

    /**
     * 编辑权限
     */
    @RequestMapping(value = "/authorization", method = RequestMethod.PUT)
    @ApiOperation(value = "编辑权限", notes = "编辑权限")
    public ResponseMessage<JSONObject> editAuthorization(EditAuthorizationVO vo) {
        return authorizationService.editAuthorization(vo);
    }

}
