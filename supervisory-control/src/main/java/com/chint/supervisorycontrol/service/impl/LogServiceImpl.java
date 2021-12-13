package com.chint.supervisorycontrol.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.chint.supervisorycontrol.constants.ResponseMessage;
import com.chint.supervisorycontrol.service.LogService;
import com.chint.supervisorycontrol.vo.logVO.ListLogVO;
import org.springframework.stereotype.Service;

/**
 * @author zhouying3
 */
@Service
public class LogServiceImpl implements LogService {
    @Override
    public ResponseMessage<JSONObject> listLog(ListLogVO vo) {
        return null;
    }
}
