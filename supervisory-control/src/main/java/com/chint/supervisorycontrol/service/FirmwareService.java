package com.chint.supervisorycontrol.service;

import com.chint.supervisorycontrol.constants.ResponseMessage;
/**
 * @author weizibo
 */
public interface FirmwareService {

    /**
     * 固件列表
     * @return success
     */
    ResponseMessage listFirmware();
}
