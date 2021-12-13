package com.chint.supervisorycontrol.mapper;

import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author zhouying3
 */
public interface BaseMapper<T> extends Mapper<T>, MySqlMapper<T>{
}
