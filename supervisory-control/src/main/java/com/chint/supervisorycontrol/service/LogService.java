package com.chint.supervisorycontrol.service;

import com.alibaba.fastjson.JSONObject;
import com.chint.supervisorycontrol.constants.ResponseMessage;
import com.chint.supervisorycontrol.vo.logVO.ListLogVO;

/**
 * @author zhouying3
 */
public interface LogService {
    /**
     * 日志列表
     * @param vo “日志列表”
     * @return success
     */
    ResponseMessage<JSONObject> listLog(ListLogVO vo);
}
