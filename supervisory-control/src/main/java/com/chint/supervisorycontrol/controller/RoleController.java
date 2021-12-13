package com.chint.supervisorycontrol.controller;

import com.chint.supervisorycontrol.constants.ResponseMessage;
import com.chint.supervisorycontrol.service.RoleService;
import com.chint.supervisorycontrol.vo.GetRoleVO;
import com.chint.supervisorycontrol.vo.roleVO.*;
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
@RequestMapping("/role-management")
@Api(value = "角色接口", tags = "角色接口")
@AllArgsConstructor
public class RoleController {
    private final RoleService roleService;
    /**
     * 角色列表--分页
     */
    @RequestMapping(value = "/roleInfo", method = RequestMethod.GET)
    @ApiOperation(value = "角色列表", notes = "角色列表")
    public ResponseMessage listRoles(ListRoleVO vo) {
        return roleService.listRoles(vo);
    }

    /**
     * 角色列表--下拉
     */
    @RequestMapping(value = "/role/option", method = RequestMethod.GET)
    @ApiOperation(value = "角色列表--下拉", notes = "角色列表--下拉")
    public ResponseMessage listOptionRoles(ListOptionRolesVO vo) {
        return roleService.listOptionRoles(vo);
    }

    /**
     * 角色层级--下拉
     */
    @RequestMapping(value = "/roleClassOption", method = RequestMethod.GET)
    @ApiOperation(value = "角色层级--下拉", notes = "角色层级--下拉")
    public ResponseMessage listRolesClass(ListRolesClassVO vo) {
        return roleService.listRolesClass(vo);
    }

    /**
     * 新建角色
     */
    @RequestMapping(value = "/role", method = RequestMethod.POST)
    @ApiOperation(value = "新建角色", notes = "新建角色")
    public ResponseMessage addRole(@Validated @RequestBody AddRoleVO vo, BindingResult result) {
        return roleService.addRole(vo);
    }

    /**
     * 获取角色
     */
    @RequestMapping(value = "/role", method = RequestMethod.GET)
    @ApiOperation(value = "获取角色", notes = "获取角色")
    public ResponseMessage getRole(@Validated GetRoleVO vo, BindingResult result) {
        return roleService.getRole(vo);
    }

    /**
     * 编辑角色
     */
    @RequestMapping(value = "/role", method = RequestMethod.PUT)
    @ApiOperation(value = "编辑角色", notes = "编辑角色")
    public ResponseMessage updateRole(@Validated @RequestBody UpdateRoleVO vo, BindingResult result) {
        return roleService.updateRole(vo);
    }

    /**
     * 删除角色
     */
    @RequestMapping(value = "/role", method = RequestMethod.DELETE)
    @ApiOperation(value = "删除角色", notes = "删除角色")
    public ResponseMessage removeRole(@Validated RemoveRoleVO vo, BindingResult result) {
        return roleService.removeRole(vo);
    }
}
