package com.chint.supervisorycontrol.service.impl;

import com.chint.supervisorycontrol.constants.ResponseMessage;
import com.chint.supervisorycontrol.service.FirmwareService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author zhouying3
 */
@Service
@AllArgsConstructor
public class FirmwareServiceImpl implements FirmwareService {
    @Override
    public ResponseMessage listFirmware() {
        return null;
    }
}
