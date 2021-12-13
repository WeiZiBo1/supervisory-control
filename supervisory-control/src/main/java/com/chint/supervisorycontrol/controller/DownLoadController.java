package com.chint.supervisorycontrol.controller;

import com.chint.supervisorycontrol.service.DownLoadService;
import com.chint.supervisorycontrol.vo.downloadVO.PowerStationDownloadVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * @author zhouying3
 */
@RestController
@RequestMapping("/download-management")
@Api(value = "下载接口", tags = "下载接口")
@AllArgsConstructor
public class DownLoadController {

    private final DownLoadService downLoadService;

    @ApiOperation(value = "电站excel下载", notes = "电站excel下载")
    @RequestMapping(value = "excel/powerStation", method = RequestMethod.GET)
    public void download(HttpServletResponse response, PowerStationDownloadVO vo) throws IOException {
        downLoadService.powerStationDownload(response, vo);
    }
}
