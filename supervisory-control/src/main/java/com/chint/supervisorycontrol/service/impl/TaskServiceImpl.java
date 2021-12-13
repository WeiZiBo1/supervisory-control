package com.chint.supervisorycontrol.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.chint.supervisorycontrol.constants.ResponseMessage;
import com.chint.supervisorycontrol.service.TaskService;
import com.chint.supervisorycontrol.vo.taskVO.*;
import org.springframework.stereotype.Service;

/**
 * @author zhouying3
 */
@Service
public class TaskServiceImpl implements TaskService {
    @Override
    public ResponseMessage<JSONObject> listMessageInfos(ListMessageInfosVO vo) {
        return null;
    }

    @Override
    public ResponseMessage<JSONObject> listWarningInfos(ListWarningInfosVO vo) {
        return null;
    }

    @Override
    public ResponseMessage<JSONObject> listConsumerInfos(ListConsumerInfosVO vo) {
        return null;
    }

    @Override
    public ResponseMessage<JSONObject> addConsumer(AddConsumerVO vo) {
        return null;
    }

    @Override
    public ResponseMessage<JSONObject> removeConsumer(RemoveConsumerVO vo) {
        return null;
    }

    @Override
    public ResponseMessage<JSONObject> listTemporaryTaskInfos(ListTemporaryTaskInfosVO vo) {
        return null;
    }

    @Override
    public ResponseMessage<JSONObject> addTemporaryTask(AddTemporaryTaskVO vo) {
        return null;
    }

    @Override
    public ResponseMessage<JSONObject> removeTemporaryTask(RemoveTemporaryTaskVO vo) {
        return null;
    }

    @Override
    public ResponseMessage<JSONObject> listHardwareTaskInfos(ListHardwareTaskInfosVO vo) {
        return null;
    }

    @Override
    public ResponseMessage<JSONObject> getHardwareTask(GetHardwareTaskVO vo) {
        return null;
    }

    @Override
    public ResponseMessage<JSONObject> addHardwareTask(AddHardwareTaskVO vo) {
        return null;
    }

    @Override
    public ResponseMessage<JSONObject> removeHardwareTask(RemoveHardwareTaskVO vo) {
        return null;
    }

    @Override
    public ResponseMessage<JSONObject> listTasks(ListTasksVO vo) {
        return null;
    }
}
