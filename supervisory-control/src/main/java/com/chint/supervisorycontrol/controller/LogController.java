package com.chint.supervisorycontrol.controller;

import com.alibaba.fastjson.JSONObject;
import com.chint.supervisorycontrol.constants.ResponseMessage;
import com.chint.supervisorycontrol.service.LogService;
import com.chint.supervisorycontrol.vo.logVO.ListLogVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhouying3
 */
@RestController
@RequestMapping("/log-management")
@Api(value = "日志接口", tags = "日志接口")
@AllArgsConstructor
public class LogController {

    private final LogService logService;
    /**
     * 日志列表
     */
    @RequestMapping(value = "/logInfo", method = RequestMethod.GET)
    @ApiOperation(value = "日志列表", notes = "日志列表")
    public ResponseMessage<JSONObject> listLog(ListLogVO vo) {
        return logService.listLog(vo);
    }

}
