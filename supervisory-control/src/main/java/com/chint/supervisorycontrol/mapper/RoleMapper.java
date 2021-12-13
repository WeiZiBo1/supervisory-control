package com.chint.supervisorycontrol.mapper;

import com.alibaba.fastjson.JSONObject;
import com.chint.supervisorycontrol.model.RoleModel;
import com.chint.supervisorycontrol.model.UserModel;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

/**
 * @author zhouying3
 */
@Repository
@Mapper
public interface RoleMapper extends BaseMapper<RoleModel>{

    /**
     * 角色下拉列表
     * @param relateUsers 相关用户ID
     * @param roleClass 角色等级
     * @return 角色列表
     */
    List<JSONObject> listOptionRoles(Set<Long> relateUsers, Integer roleClass);

    /**
     * 角色列表
     * @param roleName 搜索内容
     * @param relateUsers 关联用户
     * @return
     */
    List<JSONObject> listRoles(String roleName, Set<Long> relateUsers);
}
