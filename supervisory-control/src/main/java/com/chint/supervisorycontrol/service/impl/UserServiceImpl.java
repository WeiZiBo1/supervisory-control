package com.chint.supervisorycontrol.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.chint.supervisorycontrol.constants.ResponseConstants;
import com.chint.supervisorycontrol.constants.ResponseMessage;
import com.chint.supervisorycontrol.enums.AccountTypeEnum;
import com.chint.supervisorycontrol.enums.RoleClassEnum;
import com.chint.supervisorycontrol.enums.SearchTypeEnum;
import com.chint.supervisorycontrol.enums.UserTypeEnum;
import com.chint.supervisorycontrol.mapper.UserMapper;
import com.chint.supervisorycontrol.model.UserModel;
import com.chint.supervisorycontrol.service.UserService;
import com.chint.supervisorycontrol.utils.SecretUtils;
import com.chint.supervisorycontrol.vo.userVO.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author zhouying3
 */
@Service
@AllArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;

    @Override
    public ResponseMessage<JSONObject> addUser(AddUserVO vo) {
        UserModel userModel = new UserModel();
        userModel.setUserName(vo.getUserName());
        userModel.setCompanyName(vo.getCompanyName());
        userModel.setEmail(vo.getEmail());
        userModel.setIsUsed(1);
        userModel.setPassword(SecretUtils.encryptByMd5(vo.getPassword()));
        userModel.setPassword(vo.getPassword());
        int insert = userMapper.insert(userModel);
        return ResponseMessage.success("添加成功"+insert);
    }

    @Override
    public ResponseMessage listUsers(SearchUserVO vo) {
        Integer searchType = vo.getSearchType();
        String searchContent = vo.getSearchContent();
        Long superPartnerId = vo.getSuperPartnerId();
        Long partnerId = vo.getPartnerId();
        List<Long> relatedId = vo.getRelatedIds();
        Integer pageNum = vo.getPageNum();
        Integer pageSize = vo.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        Example listExample = new Example(UserModel.class);
        Example.Criteria criteria = listExample.createCriteria();
        criteria.andIn("id", relatedId);
        if (searchType!=null) {
            String titleByCode = SearchTypeEnum.getTitleByCode(searchType);
            criteria.andLike(titleByCode, "%"+searchContent+"%");
        }
        if (superPartnerId!=null) {
            criteria.andEqualTo("superPartnerId", superPartnerId);
        }
        if (partnerId!=null) {
            criteria.andEqualTo("partnerId", partnerId);
        }
        List<UserModel> userModels = userMapper.selectByExample(listExample);
        if (CollectionUtils.isEmpty(userModels)) {
            return ResponseMessage.fail(ResponseConstants.GET_FAIL_MESSAGE);
        }
        return ResponseMessage.success(PageInfo.of(userModels));
    }

    @Override
    public ResponseMessage<JSONObject> removeUser(RemoveUserVO vo) {
        List<Long> relatedId = vo.getRelatedIds();
        List<Long> userIds = vo.getUserIds();
        if (!relatedId.containsAll(userIds)) {
            return ResponseMessage.fail("");
        }
        Example deleteExample = new Example(UserModel.class);
        deleteExample.createCriteria().andIn("id", userIds);
        userMapper.deleteByExample(deleteExample);
        return ResponseMessage.success(ResponseConstants.DELETE_SUCCESS_MESSAGE);
    }

    @Override
    public ResponseMessage updateUser(UpdateUserVO vo) {
        UserModel userModel = new UserModel();
        userModel.setId(vo.getUpdateUserId());
        userMapper.updateByPrimaryKeySelective(userModel);
        return null;
    }

    @Override
    public Set<Long> getRelateUsers(Long userId) {
        if (userId==null) {
            return new HashSet<>();
        }
        UserModel userModel = userMapper.selectByPrimaryKey(userId);
        if (userModel == null) {
            return new HashSet<>();
        }
        Integer userType = userModel.getUserType();
        Integer accountType = userModel.getAccountType();

        if (accountType.equals(AccountTypeEnum.SUB_ACCOUNT.getCode())) {
            userId = userModel.getParentId();
        }
        Example example = new Example(UserModel.class);
        Example.Criteria criteria = example.createCriteria();
        if (userType.equals(UserTypeEnum.SUPER_PARTNER.getCode())) {
            criteria.andEqualTo("superPartnerId", userId);
        }
        if (userType.equals(UserTypeEnum.PARTNER.getCode())) {
            criteria.andEqualTo("partnerId", userId);
        }
        if (userType.equals(UserTypeEnum.FINAL_USER.getCode())) {
            criteria.andEqualTo("finalUserId", userId);
        }

        List<UserModel> userModels = userMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(userModels)) {
            return new HashSet<>();
        }
        return userModels.stream().map(UserModel::getId).collect(Collectors.toSet());
    }

    @Override
    public ResponseMessage getUsers(GetUserVO vo) {
        Long userId = vo.getUserId();
        UserModel userModel = userMapper.selectByPrimaryKey(userId);
        if (userModel == null) {
            return ResponseMessage.fail(ResponseConstants.GET_FAIL_MESSAGE);
        }
        return ResponseMessage.success(userModel);
    }

    @Override
    public ResponseMessage updateUser(UpdateUserPasswordVO vo) {
        return null;
    }

    @Override
    public ResponseMessage listSuperPartner(SearchSuperPartnerVO vo) {
        Integer userType = vo.getUserType();
        boolean isSuperAdmin = UserTypeEnum.ADMINISTRATOR.getCode().equals(userType);
        if (!isSuperAdmin) {
            return ResponseMessage.success(PageInfo.of(new ArrayList<>()));
        }
        Integer searchType = vo.getSearchType();
        String searchContent = vo.getSearchContent();
        Integer pageNum = vo.getPageNum();
        Integer pageSize = vo.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<JSONObject> userModels = userMapper.listSuperPartner(searchType,searchContent);
        return ResponseMessage.success(PageInfo.of(Optional.of(userModels).orElse(new ArrayList<>())));
    }

    @Override
    public ResponseMessage addSuperPartner(AddSuperPartnerVO vo) {
        String companyName = vo.getCompanyName();
        String email = vo.getEmail();
        String password = vo.getPassword();
        Integer using = vo.getUsing();
        Long roleId = vo.getRoleId();
        Long userId = vo.getUserId();
        //检测是否弱密码
        boolean isWeekPassword = checkWeekPassword(password);
        if (isWeekPassword) {
            return ResponseMessage.fail(ResponseConstants.WEEK_PASSWORD_MESSAGE);
        }
        //检测 公司名，邮箱 是否重复
        boolean checkResult = checkCompanyNameAndEmail(companyName, email,null);
        if (checkResult){
            return ResponseMessage.fail(ResponseConstants.DUPLICATE_EMAIL_OR_COMPANY_NAME_MESSAGE);
        }
        UserModel userModel = new UserModel();
        userModel.setCompanyName(companyName);
        userModel.setUserName(email);
        userModel.setEmail(email);
        userModel.setRoleId(roleId);
        //加密
        userModel.setPassword(SecretUtils.encryptByMd5(password));
        userModel.setIsUsed(using);
        userModel.setUserType(UserTypeEnum.SUPER_PARTNER.getCode());
        userModel.setAccountType(AccountTypeEnum.MAIN_ACCOUNT.getCode());
        userModel.setParentId(userId);
        userModel.setCreateUser(userId);
        LocalDateTime now = LocalDateTime.now();
        userModel.setCreateTime(now);
        userModel.setUpdateTime(now);
        int insert = userMapper.insert(userModel);
        if (insert>0) {
            return ResponseMessage.success(ResponseConstants.ADD_SUCCESS_MESSAGE);
        }
        return ResponseMessage.fail(ResponseConstants.ADD_FAIL_MESSAGE);
    }

    @Override
    public ResponseMessage updateSuperPartner(UpdateSuperPartnerVO vo) {
        Long userId = vo.getUserId();
        String companyName = vo.getCompanyName();
        String email = vo.getEmail();
        Long id = vo.getId();
        //校验名字
        boolean checkResult = checkCompanyNameAndEmail(companyName, email, id);
        if (checkResult) {
            return ResponseMessage.fail(ResponseConstants.DUPLICATE_EMAIL_OR_COMPANY_NAME_MESSAGE);
        }
        UserModel userModel = new UserModel();
        userModel.setUserName(email);
        userModel.setId(id);
        userModel.setCompanyName(companyName);
        userModel.setEmail(email);
        userModel.setRoleId(vo.getRoleId());
        userModel.setUpdateUser(userId);
        userModel.setUpdateTime(LocalDateTime.now());
        userModel.setIsUsed(vo.getUsing());
        int update = userMapper.updateByPrimaryKeySelective(userModel);
        if (update<1){
            log.info(ResponseConstants.UPDATE_FAIL_MESSAGE+id);
            return ResponseMessage.fail(ResponseConstants.UPDATE_FAIL_MESSAGE);
        }
        return ResponseMessage.success(ResponseConstants.UPDATE_SUCCESS_MESSAGE);
    }

    @Override
    public ResponseMessage deleteSuperPartner(DeleteSuperPartnerVO vo) {
        if (!vo.getUserType().equals(UserTypeEnum.ADMINISTRATOR.getCode())) {
            return ResponseMessage.fail(ResponseConstants.NONE_OPERATION_RIGHT);
        }
        Long id = vo.getId();
        int i = userMapper.deleteByPrimaryKey(id);
        if (i==1){
            return ResponseMessage.success(ResponseConstants.DELETE_SUCCESS_MESSAGE);
        }
        return ResponseMessage.fail(ResponseConstants.DELETE_FAIL_MESSAGE);
    }

    @Override
    public ResponseMessage listSuperPartnerSubAccounts(SearchSuperPartnerSubAccountsVO vo) {
        Long userId = vo.getUserId();
        Integer userType = vo.getUserType();
        Integer accountType = vo.getAccountType();
        Integer pageNum = vo.getPageNum();
        Integer pageSize = vo.getPageSize();
        boolean isSubAccount = AccountTypeEnum.SUB_ACCOUNT.getCode().equals(accountType);
        boolean userTypePermit = userType > 1;
        if (isSubAccount || userTypePermit) {
            return ResponseMessage.success(PageInfo.of(new ArrayList<>()));
        }
        String searchContent = vo.getSearchContent();
        Integer searchType = vo.getSearchType();
        Set<Long> relateUsers = getRelateUsers(userId);
        PageHelper.startPage(pageNum, pageSize);
        List<JSONObject> subAccountLists = userMapper.listSubAccount(searchType,searchContent,relateUsers, RoleClassEnum.SUPER_PARTNER_ROLE.getCode());
        return ResponseMessage.success(PageInfo.of(Optional.ofNullable(subAccountLists).orElse(new ArrayList<>())));
    }

    /**
     * 检测 公司名，邮箱 是否重复
     * @param companyName 公司名
     * @param email 邮箱
     * @return true重复 false不重复
     */
    private boolean checkCompanyNameAndEmail(String companyName, String email, Long userId){
        Example example = new Example(UserModel.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.orEqualTo("companyName", companyName);
        criteria.orEqualTo("email", email);
        if (userId!=null) {
            criteria.andNotEqualTo("id", userId);
        }
        List<UserModel> userModels = userMapper.selectByExample(example);
        return CollectionUtils.isNotEmpty(userModels);
    }


    /**
     * 检测 弱密码
     * @param password 密码
     * @return true 弱密码
     */
    private boolean checkWeekPassword(String password){
        // todo
        return false;
    }
}
