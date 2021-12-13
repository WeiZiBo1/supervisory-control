package com.chint.supervisorycontrol.constants;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.data.annotation.Transient;

import java.io.Serializable;
import java.util.List;

/**
 * @author zhouying3
 * 通用返回对象
 */
public class ResponseMessage<T> implements Serializable {
    private int code;
    private boolean success;
    private T data;
    private String message;

    public ResponseMessage() {
    }

    private ResponseMessage(int code, String message) {
        this.code = code;
        this.message = message;
    }

    private ResponseMessage(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> ResponseMessage<T> error(String message) {
        return new ResponseMessage<>(ResponseConstants.ERROR_CODE, message);
    }

    public static <T> ResponseMessage<T> error() {
        return new ResponseMessage<>(ResponseConstants.ERROR_CODE, ResponseConstants.ERROR_MESSAGE);
    }

    public static <T> ResponseMessage<T> fail(String message) {
        return new ResponseMessage<>(ResponseConstants.FAIL_CODE, message);
    }

    public static <T> ResponseMessage<T> fail() {
        return new ResponseMessage<>(ResponseConstants.FAIL_CODE, ResponseConstants.FAIL_MESSAGE);
    }

    @Deprecated
    public static <T> ResponseMessage<T> fail(int code, String message) {
        return new ResponseMessage<>(code, message);
    }

    @Deprecated
    public static <T> ResponseMessage<T> fail(int code, String message, T result) {
        return new ResponseMessage<>(code, message, result);
    }

    public static <T> ResponseMessage<T> success(String message) {
        return new ResponseMessage<>(ResponseConstants.SUCCESS_CODE, message);
    }

    public static <T> ResponseMessage<T> success() {
        return new ResponseMessage<>(ResponseConstants.SUCCESS_CODE, ResponseConstants.SUCCESS_MESSAGE);
    }

    public static <T> ResponseMessage<T> success(String message, T result) {
        return new ResponseMessage<>(ResponseConstants.SUCCESS_CODE, message, result);
    }

    public static <T> ResponseMessage<T> success(T result) {
        return new ResponseMessage<>(ResponseConstants.SUCCESS_CODE, ResponseConstants.SUCCESS_MESSAGE, result);
    }

    @Deprecated
    public static <T> ResponseMessage<T> success(int code, String message, T result) {
        return new ResponseMessage<>(code, message, result);
    }

    public static <T> ResponseMessage<T> instance(int code, String message) {
        return new ResponseMessage<>(code, message);
    }

    public static <T> ResponseMessage<T> instance(int code, String message, T result) {
        return new ResponseMessage<>(code, message, result);
    }

    public int getCode() {
        return code;
    }

    public T getData() {
        return data;
    }

    @Transient
    public JSONObject transferToJsonObject() {
        if (data != null) {
            return JSON.parseObject(JSON.toJSONString(data));
        }
        return null;
    }

    @Transient
    public List<JSONObject> transferToJsonObjectList() {
        if (data != null) {
            return JSON.parseArray(JSON.toJSONString(data)).toJavaList(JSONObject.class);
        }
        return null;
    }

    public boolean isSuccess() {
        return this.code == ResponseConstants.SUCCESS_CODE;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setCode(int code) {
        this.code = code;
    }
}