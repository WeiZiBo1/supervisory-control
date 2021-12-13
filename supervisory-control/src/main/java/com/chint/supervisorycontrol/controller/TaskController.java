package com.chint.supervisorycontrol.controller;

import com.alibaba.fastjson.JSONObject;
import com.chint.supervisorycontrol.constants.ResponseMessage;
import com.chint.supervisorycontrol.service.TaskService;
import com.chint.supervisorycontrol.vo.taskVO.*;
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
@RequestMapping("/task-management")
@Api(value = "任务接口", tags = "任务接口")
@AllArgsConstructor
public class TaskController {
    private final TaskService taskService;

    /**
     * 消息列表
     */
    @RequestMapping(value = "/messageInfos", method = RequestMethod.GET)
    @ApiOperation(value = "消息列表", notes = "消息列表")
    public ResponseMessage<JSONObject> listMessageInfos(ListMessageInfosVO vo) {
        return taskService.listMessageInfos(vo);
    }

    /**
     * 事件警告列表
     */
    @RequestMapping(value = "/warningInfos", method = RequestMethod.GET)
    @ApiOperation(value = "事件警告列表", notes = "事件警告列表")
    public ResponseMessage<JSONObject> listWarningInfos(ListWarningInfosVO vo) {
        return taskService.listWarningInfos(vo);
    }

    /**
     * 事件订阅列表
     */
    @RequestMapping(value = "/consumerInfos", method = RequestMethod.GET)
    @ApiOperation(value = "事件订阅列表", notes = "事件订阅列表")
    public ResponseMessage<JSONObject> listConsumerInfos(ListConsumerInfosVO vo) {
        return taskService.listConsumerInfos(vo);
    }

    /**
     * 添加事件订阅
     */
    @RequestMapping(value = "/consumer", method = RequestMethod.POST)
    @ApiOperation(value = "添加事件订阅", notes = "添加事件订阅")
    public ResponseMessage<JSONObject> addConsumer(AddConsumerVO vo) {
        return taskService.addConsumer(vo);
    }

    /**
     * 删除事件订阅
     */
    @RequestMapping(value = "/consumer", method = RequestMethod.DELETE)
    @ApiOperation(value = "删除事件订阅", notes = "删除事件订阅")
    public ResponseMessage<JSONObject> removeConsumer(RemoveConsumerVO vo) {
        return taskService.removeConsumer(vo);
    }


    /**
     * 远程设置列表(寄存器列表)
     */
    @RequestMapping(value = "/temporaryInfos", method = RequestMethod.GET)
    @ApiOperation(value = "远程设置列表(寄存器列表)", notes = "远程设置列表(寄存器列表)")
    public ResponseMessage<JSONObject> listTemporaryTaskInfos(ListTemporaryTaskInfosVO vo) {
        return taskService.listTemporaryTaskInfos(vo);
    }

    /**
     * 添加寄存器任务
     */
    @RequestMapping(value = "/temporary", method = RequestMethod.POST)
    @ApiOperation(value = "添加寄存器任务", notes = "添加寄存器任务")
    public ResponseMessage<JSONObject> addTemporaryTask(AddTemporaryTaskVO vo) {
        return taskService.addTemporaryTask(vo);
    }

    /**
     * 删除寄存器任务
     */
    @RequestMapping(value = "/temporary", method = RequestMethod.DELETE)
    @ApiOperation(value = "删除寄存器任务", notes = "删除寄存器任务")
    public ResponseMessage<JSONObject> removeTemporaryTask(RemoveTemporaryTaskVO vo) {
        return taskService.removeTemporaryTask(vo);
    }

    /**
     * 固件升级列表
     */
    @RequestMapping(value = "/hardwareInfos", method = RequestMethod.GET)
    @ApiOperation(value = "固件升级列表", notes = "固件升级列表")
    public ResponseMessage<JSONObject> listHardwareTaskInfos(ListHardwareTaskInfosVO vo) {
        return taskService.listHardwareTaskInfos(vo);
    }

    /**
     * 查询固件升级任务
     */
    @RequestMapping(value = "/hardware", method = RequestMethod.GET)
    @ApiOperation(value = "查询固件升级任务", notes = "查询固件升级任务")
    public ResponseMessage<JSONObject> getHardwareTask(GetHardwareTaskVO vo) {
        return taskService.getHardwareTask(vo);
    }

    /**
     * 添加固件升级任务
     */
    @RequestMapping(value = "/hardware", method = RequestMethod.POST)
    @ApiOperation(value = "添加固件升级任务", notes = "添加固件升级任务")
    public ResponseMessage<JSONObject> addHardwareTask(AddHardwareTaskVO vo) {
        return taskService.addHardwareTask(vo);
    }

    /**
     * 删除固件升级任务
     */
    @RequestMapping(value = "/hardware", method = RequestMethod.DELETE)
    @ApiOperation(value = "删除固件升级任务", notes = "删除固件升级任务")
    public ResponseMessage<JSONObject> removeHardwareTask(RemoveHardwareTaskVO vo) {
        return taskService.removeHardwareTask(vo);
    }

    /**
     * 全部任务
     */
    @RequestMapping(value = "/tasks", method = RequestMethod.GET)
    @ApiOperation(value = "全部任务", notes = "全部任务")
    public ResponseMessage<JSONObject> listTasks(ListTasksVO vo) {
        return taskService.listTasks(vo);
    }
}
