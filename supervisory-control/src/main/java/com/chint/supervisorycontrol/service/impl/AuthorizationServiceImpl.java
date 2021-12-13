package com.chint.supervisorycontrol.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.chint.supervisorycontrol.constants.ResponseConstants;
import com.chint.supervisorycontrol.constants.ResponseMessage;
import com.chint.supervisorycontrol.enums.AccountTypeEnum;
import com.chint.supervisorycontrol.enums.RoleClassEnum;
import com.chint.supervisorycontrol.mapper.AuthorizationMapper;
import com.chint.supervisorycontrol.mapper.AuthorizationRelationMapper;
import com.chint.supervisorycontrol.model.AuthorizationModel;
import com.chint.supervisorycontrol.model.AuthorizationRelationModel;
import com.chint.supervisorycontrol.service.AuthorizationService;
import com.chint.supervisorycontrol.utils.TreeUtils;
import com.chint.supervisorycontrol.vo.authorizationVO.AddAuthorizationVO;
import com.chint.supervisorycontrol.vo.authorizationVO.EditAuthorizationVO;
import com.chint.supervisorycontrol.vo.authorizationVO.ListAuthorizationVO;
import lombok.AllArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.chint.supervisorycontrol.constants.ResponseConstants.ADD_SUCCESS_MESSAGE;
import static com.chint.supervisorycontrol.constants.ResponseConstants.UPDATE_SUCCESS_MESSAGE;

/**
 * @author zhouying3
 */
@Service
@AllArgsConstructor
public class AuthorizationServiceImpl implements AuthorizationService {

    private final AuthorizationMapper authorizationMapper;

    private final AuthorizationRelationMapper authorizationRelationMapper;

    @Override
    public ResponseMessage listAuthorization(ListAuthorizationVO vo) {
        //子账户没有操作权限
        if (AccountTypeEnum.SUB_ACCOUNT.getCode().equals(vo.getAccountType())) {
            return ResponseMessage.fail(ResponseConstants.NONE_OPERATION_RIGHT);
        }
        Integer roleClass = vo.getRoleClass();
        Example example = new Example(AuthorizationModel.class);
        Example.Criteria criteria = example.createCriteria();
        //根据角色 层级，去除对应 页面权限选项
        criteria.andNotIn("id",RoleClassEnum.getBanListByCode(roleClass));
        List<AuthorizationModel> authorizationModels = authorizationMapper.selectByExample(example);

        if (CollectionUtils.isEmpty(authorizationModels)) {
            return ResponseMessage.success(new ArrayList<>());
        }

        return ResponseMessage.success(TreeUtils.convertToAuthTree(authorizationModels));
    }

    @Override
    public ResponseMessage<JSONObject> editAuthorization(EditAuthorizationVO vo) {
        Long userId = vo.getUserId();
        List<Integer> authorizationList = vo.getAuthorizationList();
        Example deleteExample = new Example(AuthorizationRelationModel.class);
        deleteExample.createCriteria().andEqualTo("userId", userId);
        authorizationRelationMapper.deleteByExample(deleteExample);
        insertAuthorizationListByRoleId(userId, authorizationList);
        return ResponseMessage.success(UPDATE_SUCCESS_MESSAGE);
    }

    @Override
    public ResponseMessage<JSONObject> addAuthorization(AddAuthorizationVO vo) {
        Long userId = vo.getUserId();
        List<Integer> authorizationList = vo.getAuthorizationList();
        insertAuthorizationListByRoleId(userId, authorizationList);
        return ResponseMessage.success(ADD_SUCCESS_MESSAGE);
    }

    private void insertAuthorizationListByRoleId(Long userId, List<Integer> authorizationList) {
        if (CollectionUtils.isNotEmpty(authorizationList)) {
            List<AuthorizationRelationModel> insertList = new ArrayList<>();
            authorizationList.forEach(authorizationPageId->{
                AuthorizationRelationModel model = new AuthorizationRelationModel();
                model.setRoleId(userId);
                model.setAuthorizationId(authorizationPageId);
                model.setGmtCreate(LocalDateTime.now());
                insertList.add(model);
            });
            authorizationRelationMapper.insertList(insertList);
        }
    }

    @Override
    public List<Integer> listAuthorizationUrl(Long roleId){
        List<JSONObject> listAuthorization = authorizationMapper.selectAuthorizationListByRoleId(roleId);
        if (CollectionUtils.isEmpty(listAuthorization)) {
            return new ArrayList<>();
        }
        return listAuthorization.stream().map(auth -> auth.getInteger("id")).collect(Collectors.toList());
    }

}
