package com.chint.supervisorycontrol.service;

import com.chint.supervisorycontrol.vo.downloadVO.PowerStationDownloadVO;

import javax.servlet.http.HttpServletResponse;

/**
 * @author zhouying3
 */
public interface DownLoadService {

    /**
     * 电站excel下载
     * @param response 返回
     * @param vo 电站搜索内容
     */
    void powerStationDownload(HttpServletResponse response, PowerStationDownloadVO vo);
}
