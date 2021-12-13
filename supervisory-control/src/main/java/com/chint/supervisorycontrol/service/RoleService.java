package com.chint.supervisorycontrol.service;

import com.chint.supervisorycontrol.constants.ResponseMessage;
import com.chint.supervisorycontrol.vo.GetRoleVO;
import com.chint.supervisorycontrol.vo.roleVO.*;

/**
 * @author zhouying3
 */
public interface RoleService {
    /**
     * 角色列表 分页
     * @param vo 角色搜索项
     * @return 角色list
     */
    ResponseMessage listRoles(ListRoleVO vo);


    /**
     * 角色列表 - option下拉选项
     * @param vo 角色类型
     * @return 角色list
     */
    ResponseMessage listOptionRoles(ListOptionRolesVO vo);

    /**
     * 角色层级
     * @return 角色层级
     */
    ResponseMessage listRolesClass(ListRolesClassVO vo);

    /**
     * 新建角色
     * @param vo 角色名称，描述，权限id列表
     * @return 新建结果
     */
    ResponseMessage addRole(AddRoleVO vo);

    /**
     * 获取角色
     * @param vo 角色ID
     * @return 角色信息
     */
    ResponseMessage getRole(GetRoleVO vo);

    /**
     * 更新角色
     * @param vo  角色名称，描述，权限id列表
     * @return 更新结果
     */
    ResponseMessage updateRole(UpdateRoleVO vo);

    /**
     * 删除角色
     * @param vo 角色ID
     * @return 删除结果
     */
    ResponseMessage removeRole(RemoveRoleVO vo);
}
