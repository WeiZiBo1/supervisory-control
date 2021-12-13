package com.chint.supervisorycontrol.mapper;

import com.alibaba.fastjson.JSONObject;
import com.chint.supervisorycontrol.model.AuthorizationModel;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zhouying3
 */

@Mapper
@Repository
public interface AuthorizationMapper extends BaseMapper<AuthorizationModel>{
    /**
     * 用户权限
     * @param roleId 角色id
     * @return 权限列表
     */
    List<JSONObject> selectAuthorizationListByRoleId(Long roleId);

}
