package com.chint.supervisorycontrol.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.chint.supervisorycontrol.constants.ResponseConstants;
import com.chint.supervisorycontrol.constants.ResponseMessage;
import com.chint.supervisorycontrol.enums.AccountTypeEnum;
import com.chint.supervisorycontrol.enums.RoleClassEnum;
import com.chint.supervisorycontrol.mapper.AuthorizationRelationMapper;
import com.chint.supervisorycontrol.mapper.RoleMapper;
import com.chint.supervisorycontrol.mapper.UserMapper;
import com.chint.supervisorycontrol.model.AuthorizationRelationModel;
import com.chint.supervisorycontrol.model.RoleModel;
import com.chint.supervisorycontrol.model.UserModel;
import com.chint.supervisorycontrol.service.RoleService;
import com.chint.supervisorycontrol.service.UserService;
import com.chint.supervisorycontrol.vo.GetRoleVO;
import com.chint.supervisorycontrol.vo.roleVO.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.AllArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author zhouying3
 */
@Service
@AllArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleMapper roleMapper;
    private final UserService userService;
    private final AuthorizationRelationMapper authorizationRelationMapper;
    private final UserMapper userMapper;

    @Override
    public ResponseMessage listRoles(ListRoleVO vo) {
        Long userId = vo.getUserId();
        String roleName = vo.getRoleName();
        Set<Long> relateUsers = userService.getRelateUsers(userId);
        //自己的角色不可控
        if (userId!=1) {
            relateUsers.remove(userId);
        }
        Integer pageNum = vo.getPageNum();
        Integer pageSize = vo.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<JSONObject> roleList = roleMapper.listRoles(roleName, relateUsers);
        return ResponseMessage.success(PageInfo.of(Optional.ofNullable(roleList).orElse(new ArrayList<>())));
    }

    @Override
    public ResponseMessage listOptionRoles(ListOptionRolesVO vo) {
        Long userId = vo.getUserId();
        Integer userType = vo.getUserType();
        Integer accountType = vo.getAccountType();
        Set<Long> relateUsers = userService.getRelateUsers(userId);
        if (CollectionUtils.isEmpty(relateUsers)) {
            return ResponseMessage.success(ResponseConstants.NONE_RELATED_USERS,new ArrayList<>());
        }
        Integer roleClass = vo.getRoleClass();
        List<JSONObject> roleList = roleMapper.listOptionRoles(relateUsers, roleClass);
        if (CollectionUtils.isEmpty(roleList)) {
            return ResponseMessage.success(new ArrayList<>());
        }
        return ResponseMessage.success(roleList);
    }

    @Override
    public ResponseMessage listRolesClass(ListRolesClassVO vo) {
        Integer userType = vo.getUserType();
        Integer accountType = vo.getAccountType();
        //子账号，不给予创建角色权限
        if (accountType.equals(AccountTypeEnum.SUB_ACCOUNT.getCode())) {
            return ResponseMessage.success(new ArrayList<>());
        }
        List<JSONObject> list = RoleClassEnum.listRoleClassEnum(userType);
        return ResponseMessage.success(list);
    }

    @Override
    public ResponseMessage addRole(AddRoleVO vo) {
        Integer accountType = vo.getAccountType();
        //子账号没有创建角色 权限
        if (AccountTypeEnum.SUB_ACCOUNT.getCode().equals(accountType)) {
            return ResponseMessage.fail(ResponseConstants.NONE_OPERATION_RIGHT);
        }
        String roleName = vo.getRoleName();
        Long userId = vo.getUserId();
        Integer roleClass = vo.getRoleClass();
        String roleDescription = vo.getRoleDescription();
        List<Integer> authorizationList = vo.getAuthorizationList();
        //校验角色名是否重复
        boolean isDuplicate = duplicateRoleName(roleName,userId,roleClass,null);
        if (isDuplicate) {
            return ResponseMessage.fail(ResponseConstants.DUPLICATE_ROLE_NAME_MESSAGE);
        }
        RoleModel roleModel = new RoleModel();
        roleModel.setRoleName(roleName);
        roleModel.setRoleInstruction(roleDescription);
        roleModel.setIsUsed(vo.getIsUsed());
        roleModel.setRoleClass(roleClass);
        roleModel.setCreateBy(userId);
        LocalDateTime now = LocalDateTime.now();
        roleModel.setGmtCreate(now);
        roleModel.setGmtModified(now);
        roleMapper.insertUseGeneratedKeys(roleModel);
        //更新角色关系表
        Long roleId = roleModel.getId();
        Example example = new Example(AuthorizationRelationModel.class);
        example.createCriteria().andEqualTo("roleId", roleId);
        authorizationRelationMapper.deleteByExample(example);
        saveAuthorizationRelation(roleId, now, authorizationList);
        return ResponseMessage.success(ResponseConstants.ADD_SUCCESS_MESSAGE);
    }

    @Override
    public ResponseMessage getRole(GetRoleVO vo) {
        Long roleId = vo.getRoleId();
        RoleModel roleModel = roleMapper.selectByPrimaryKey(roleId);
        if (roleModel==null) {
            return ResponseMessage.fail(ResponseConstants.GET_FAIL_MESSAGE);
        }
        Example example = new Example(AuthorizationRelationModel.class);
        example.createCriteria().andEqualTo("roleId", roleId);
        List<AuthorizationRelationModel> modelList = authorizationRelationMapper.selectByExample(example);
        List<Integer> pageIds = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(modelList)) {
            pageIds = modelList.stream().map(AuthorizationRelationModel::getAuthorizationId).collect(Collectors.toList());
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("roleName", roleModel.getRoleName());
        jsonObject.put("roleClass", roleModel.getRoleClass());
        jsonObject.put("roleDescription", roleModel.getRoleInstruction());
        jsonObject.put("checkPages", pageIds);
        return ResponseMessage.success(jsonObject);
    }

    @Override
    public ResponseMessage updateRole(UpdateRoleVO vo) {
        Long userId = vo.getUserId();
        Long roleId = vo.getRoleId();
        String roleName = vo.getRoleName();
        Integer roleClass = vo.getRoleClass();
        Integer isUsed = vo.getIsUsed();
        String roleDescription = vo.getRoleDescription();
        LocalDateTime now = LocalDateTime.now();
        //校验重名
        boolean duplicateRoleName = duplicateRoleName(roleName, userId, roleClass, roleId);
        if (duplicateRoleName) {
            return ResponseMessage.fail(ResponseConstants.DUPLICATE_ROLE_NAME_MESSAGE);
        }
        //更新角色列表
        RoleModel roleModel = new RoleModel();
        roleModel.setId(roleId);
        roleModel.setRoleName(roleName);
        roleModel.setRoleClass(roleClass);
        roleModel.setGmtModified(now);
        roleModel.setRoleInstruction(roleDescription);
        roleModel.setIsUsed(isUsed);
        roleMapper.updateByPrimaryKeySelective(roleModel);
        //更新 权限列表
        List<Integer> authorizationList = vo.getAuthorizationList();
        Example example = new Example(AuthorizationRelationModel.class);
        example.createCriteria().andEqualTo("roleId", roleId);
        authorizationRelationMapper.deleteByExample(example);
        saveAuthorizationRelation(roleId, now, authorizationList);
        return ResponseMessage.success(ResponseConstants.UPDATE_SUCCESS_MESSAGE);
    }

    @Override
    public ResponseMessage removeRole(RemoveRoleVO vo) {
        Long roleId = vo.getRoleId();
        //已绑定角色无法删除
        Example userExample = new Example(UserModel.class);
        userExample.createCriteria().andEqualTo("roleId", roleId);
        List<UserModel> userModels = userMapper.selectByExample(userExample);
        if (CollectionUtils.isNotEmpty(userModels)) {
            return ResponseMessage.fail(ResponseConstants.UNABLE_DELETE_BIND_ROLE);
        }
        //删除角色
        roleMapper.deleteByPrimaryKey(roleId);
        //删除角色 权限 关系表
        Example relationExample = new Example(AuthorizationRelationModel.class);
        relationExample.createCriteria().andEqualTo("roleId", roleId);
        authorizationRelationMapper.deleteByExample(relationExample);
        return ResponseMessage.success(ResponseConstants.DELETE_SUCCESS_MESSAGE);
    }

    private void saveAuthorizationRelation(Long roleId, LocalDateTime now, List<Integer> authorizationList) {
        if (CollectionUtils.isNotEmpty(authorizationList)) {
            List<AuthorizationRelationModel> authorizationRelationModels = new ArrayList<>();
            for (Integer authorizationId : authorizationList) {
                AuthorizationRelationModel model = new AuthorizationRelationModel();
                model.setRoleId(roleId);
                model.setAuthorizationId(authorizationId);
                model.setGmtCreate(now);
                authorizationRelationModels.add(model);
            }
            authorizationRelationMapper.insertList(authorizationRelationModels);
        }
    }

    private boolean duplicateRoleName(String roleName,Long userId,Integer roleClass,Long roleId){
        Set<Long> relateUsers = userService.getRelateUsers(userId);
        Example example = new Example(RoleModel.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("roleName", roleName);
        criteria.andEqualTo("roleClass", roleClass);
        criteria.andIn("createBy", relateUsers);
        if (roleId!=null) {
            criteria.andNotEqualTo("id", roleId);
        }
        List<RoleModel> roleModels = roleMapper.selectByExample(example);
        return CollectionUtils.isNotEmpty(roleModels);
    }
}
