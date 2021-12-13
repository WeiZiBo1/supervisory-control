package com.chint.supervisorycontrol.service;

import com.alibaba.fastjson.JSONObject;
import com.chint.supervisorycontrol.constants.ResponseMessage;
import com.chint.supervisorycontrol.vo.taskVO.*;

/**
 * @author zhouying3
 */
public interface TaskService {

    /**
     * 消息列表
     * @param vo “消息列表”
     * @return ResponseMessage
     */
    ResponseMessage<JSONObject> listMessageInfos(ListMessageInfosVO vo);


    /**
     * 事件警告列表
     * @param vo “事件警告列表”
     * @return ResponseMessage
     */
    ResponseMessage<JSONObject> listWarningInfos(ListWarningInfosVO vo);


    /**
     * 事件订阅列表
     * @param vo “事件订阅列表”
     * @return ResponseMessage
     */
    ResponseMessage<JSONObject> listConsumerInfos(ListConsumerInfosVO vo);


    /**
     * 添加事件订阅
     * @param vo “添加事件订阅”
     * @return ResponseMessage
     */
    ResponseMessage<JSONObject> addConsumer(AddConsumerVO vo);

    /**
     * 删除事件订阅
     * @param vo “删除事件订阅”
     * @return ResponseMessage
     */
    ResponseMessage<JSONObject> removeConsumer(RemoveConsumerVO vo);


    /**
     * 远程设置列表(寄存器列表)
     * @param vo “远程设置列表(寄存器列表)”
     * @return ResponseMessage
     */
    ResponseMessage<JSONObject> listTemporaryTaskInfos(ListTemporaryTaskInfosVO vo);


    /**
     * 添加寄存器任务
     * @param vo “添加寄存器任务”
     * @return ResponseMessage
     */
    ResponseMessage<JSONObject> addTemporaryTask(AddTemporaryTaskVO vo);

    /**
     * 删除寄存器任务
     * @param vo “删除寄存器任务”
     * @return ResponseMessage
     */
    ResponseMessage<JSONObject> removeTemporaryTask(RemoveTemporaryTaskVO vo);

    /**
     * 固件升级列表
     * @param vo “固件升级列表”
     * @return ResponseMessage
     */
    ResponseMessage<JSONObject> listHardwareTaskInfos(ListHardwareTaskInfosVO vo);


    /**
     * 查询固件升级任务
     * @param vo “查询固件升级任务”
     * @return ResponseMessage
     */
    ResponseMessage<JSONObject> getHardwareTask(GetHardwareTaskVO vo);


    /**
     * 添加固件升级任务
     * @param vo “添加固件升级任务”
     * @return ResponseMessage
     */
    ResponseMessage<JSONObject> addHardwareTask(AddHardwareTaskVO vo);

    /**
     * 删除固件升级任务
     * @param vo “删除固件升级任务”
     * @return ResponseMessage
     */
    ResponseMessage<JSONObject> removeHardwareTask(RemoveHardwareTaskVO vo);


    /**
     * 全部任务
     * @param vo “全部任务”
     * @return ResponseMessage
     */
    ResponseMessage<JSONObject> listTasks(ListTasksVO vo);
}
