package com.chint.supervisorycontrol.utils;

import com.alibaba.fastjson.JSONObject;
import com.chint.supervisorycontrol.model.AuthorizationModel;
import com.chint.supervisorycontrol.model.AuthorizationTreeModel;
import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author zhouying3
 */
public class TreeUtils {
    public static List<AuthorizationTreeModel> convertToAuthTree( List<AuthorizationModel> authList){
        HashMap<Integer, List<AuthorizationTreeModel>> childMap = new HashMap<>(16);
        List<AuthorizationTreeModel> topList = new ArrayList<>();
        for (AuthorizationModel authorizationModel : authList) {
            Integer id = authorizationModel.getId();
            Integer parentId = authorizationModel.getParentId();
            String name = authorizationModel.getAuthorizationDetail();
            childMap.computeIfAbsent(parentId, key -> new ArrayList<>());
            AuthorizationTreeModel authorizationTreeModel = new AuthorizationTreeModel();
            authorizationTreeModel.setId(id);
            authorizationTreeModel.setParentId(parentId);
            authorizationTreeModel.setName(name);
            childMap.get(parentId).add(authorizationTreeModel);
            if (parentId == 0) {
                topList.add(authorizationTreeModel);
            }
        }
        for (AuthorizationTreeModel authorizationTreeModel : topList) {
            setSubList(authorizationTreeModel,childMap);
        }
        return topList;
    }

    private static void setSubList(AuthorizationTreeModel model, HashMap<Integer, List<AuthorizationTreeModel>> childMap){
        Integer id = model.getId();
        List<AuthorizationTreeModel> authorizationTreeModels = childMap.get(id);
        if (CollectionUtils.isEmpty(authorizationTreeModels)) {
         return;
        }
        model.setChildModelList(authorizationTreeModels);
        for (AuthorizationTreeModel authorizationTreeModel : authorizationTreeModels) {
            setSubList(authorizationTreeModel,childMap);
        }
    }
}
