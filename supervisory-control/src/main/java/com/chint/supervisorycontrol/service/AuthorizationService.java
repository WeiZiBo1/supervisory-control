package com.chint.supervisorycontrol.service;

import com.alibaba.fastjson.JSONObject;
import com.chint.supervisorycontrol.constants.ResponseMessage;
import com.chint.supervisorycontrol.vo.authorizationVO.AddAuthorizationVO;
import com.chint.supervisorycontrol.vo.authorizationVO.EditAuthorizationVO;
import com.chint.supervisorycontrol.vo.authorizationVO.ListAuthorizationVO;

import java.util.List;

/**
 * @author zhouying3
 */
public interface AuthorizationService {
    /**
     * 授权列表
     * @param vo “角色ID”
     * @return 授权列表
     */
    ResponseMessage listAuthorization(ListAuthorizationVO vo);

    /**
     * 授权列表
     * @param vo “搜索条件”
     * @return 授权列表
     */
    ResponseMessage<JSONObject> editAuthorization(EditAuthorizationVO vo);


    /**
     * 授权列表
     * @param vo “搜索条件”
     * @return 授权列表
     */
    ResponseMessage<JSONObject> addAuthorization(AddAuthorizationVO vo);

    /**
     * 授权路径列表
     * @param userId “用户ID”
     * @return 授权路径列表
     */
    List<Integer> listAuthorizationUrl(Long userId);
}
