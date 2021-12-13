package com.chint.supervisorycontrol.service.impl;

import com.alibaba.excel.EasyExcel;
import com.chint.supervisorycontrol.constants.CommonConstants;
import com.chint.supervisorycontrol.constants.ExceptionConstants;
import com.chint.supervisorycontrol.exception.GlobalException;
import com.chint.supervisorycontrol.mapper.PowerStationMapper;
import com.chint.supervisorycontrol.model.UserModel;
import com.chint.supervisorycontrol.service.DownLoadService;
import com.chint.supervisorycontrol.vo.downloadVO.PowerStationDownloadVO;
import com.github.pagehelper.PageHelper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;

/**
 * @author zhouying3
 */
@Service
@AllArgsConstructor
public class DownLoadServiceImpl implements DownLoadService {

    private final PowerStationMapper powerStationMapper;
    @Override
    public void powerStationDownload(HttpServletResponse response, PowerStationDownloadVO vo) {
        Integer pageNum = vo.getPageNum();
        Integer pageSize = vo.getPageSize();
        Long superPartnerId = vo.getSuperPartnerId();
        Long partnerId = vo.getPartnerId();
        Long finalUserId = vo.getFinalUserId();
        PageHelper.startPage(pageNum, pageSize);
        //todo

        String fileName = "";
        downloadExcel(fileName,response, UserModel.class , new ArrayList<>());
    }

    private void downloadExcel(String fileName,HttpServletResponse response, Class<?> clazz, Collection<?> data){
        // 这里注意 有同学反应使用swagger 会导致各种问题，请直接用浏览器或者用postman
        response.setContentType(CommonConstants.EXCEL_RESPONSE_CONTENT_TYPE);
        response.setCharacterEncoding(CommonConstants.EXCEL_RESPONSE_CHARACTER_ENCODING);
        // 这里URLEncoder.encode可以防止中文乱码 当然和EasyExcel没有关系
        try {
            String encodeFileName = URLEncoder.encode(fileName, "UTF-8");
            response.setHeader("Content-disposition", "attachment;filename=" + encodeFileName + CommonConstants.EXCEL_SUFFIX);
            EasyExcel.write(response.getOutputStream(), clazz).sheet("sheet1").doWrite(data);
        } catch (IOException e) {
            e.printStackTrace();
            throw new GlobalException(500, ExceptionConstants.EXCEL_IO_EXCEPTION);
        }
    }
}
