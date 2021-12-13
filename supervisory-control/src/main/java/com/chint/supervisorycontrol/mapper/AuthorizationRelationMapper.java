package com.chint.supervisorycontrol.mapper;

import com.chint.supervisorycontrol.model.AuthorizationRelationModel;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author zhouying3
 */
@Repository
@Mapper
public interface AuthorizationRelationMapper extends BaseMapper<AuthorizationRelationModel>{
}
