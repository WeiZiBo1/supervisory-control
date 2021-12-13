package com.chint.supervisorycontrol.mapper;

import com.alibaba.fastjson.JSONObject;
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
public interface UserMapper extends BaseMapper<UserModel>{
    /**
     * 超级用户列表-分页
     * @param searchType 搜索类型  1）邮箱； 2）公司名
     * @param searchContent 搜索内容
     * @return
     */
    List<JSONObject> listSuperPartner(Integer searchType, String searchContent);

    /**
     * 超级用户子账号列表 - 分页
     * @param searchType 搜索类型  1）邮箱； 2）公司名
     * @param searchContent 搜索内容
     * @param relateUsers 相关用户id
     * @return
     */
    List<JSONObject> listSubAccount(Integer searchType, String searchContent,  Set<Long> relateUsers, Integer searchCode);

}
