package com.chint.supervisorycontrol.controller;

import com.chint.supervisorycontrol.constants.ResponseMessage;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhouying3
 */
@RestController
@RequestMapping("dashboard")
@Api(value = "首页接口", tags = "首页接口")
public class DashboardController {

    /**
     * 电站数据（总数，发电量，累计收入，每日通告）
     */
    @RequestMapping(value = "/dataCollection", method = RequestMethod.GET)
    public ResponseMessage dataCollection() {
        return ResponseMessage.success();
    }

    /**
     * 主页eChart图
     */
    @RequestMapping(value = "/eChartData", method = RequestMethod.GET)
    public ResponseMessage eChartData() {
        return ResponseMessage.success();
    }

    /**
     * 主页电站列表
     */
    @RequestMapping(value = "/PowerStations", method = RequestMethod.GET)
    public ResponseMessage listPowerStations() {
        return ResponseMessage.success();
    }

}
