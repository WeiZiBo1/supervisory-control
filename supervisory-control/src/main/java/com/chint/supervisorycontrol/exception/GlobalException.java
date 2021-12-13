package com.chint.supervisorycontrol.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author zhouying3
 * 全局异常
 */

@AllArgsConstructor
@Getter
@Setter
public class GlobalException extends RuntimeException{
    /**
     * 异常编号
     */
    private final int messageCode;

    /**
     * 对messageCode 异常信息进行补充说明
     */
    private final String detailMessage;

}
