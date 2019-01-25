package com.taotao.service.imp;

import com.taotao.common.utils.FtpUtil;
import com.taotao.common.utils.IDUtils;
import com.taotao.service.PictureService;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: aaaa
 * @Date: 2019/1/15 20:53
 * @Description:
 */
@Service
public class PictureServiceImpl implements PictureService {

    @Value("${FTP_ADDRESS}")
    private String FTP_ADDRESS;
    @Value("${FTP_PORT}")
    private Integer FTP_PORT;
    @Value("${FTP_USERNAME}")
    private String FTP_USERNAME;
    @Value("${FTP_PASSWORD}")
    private String FTP_PASSWORD;
    @Value("${FTP_BASE_PATH}")
    private String FTP_BASE_PATH;
    @Value("${IMAGE_BASE_URL}")
    private String IMAGE_BASE_URL;


    @Override
    public Map<String, Object> upLoadPicture(MultipartFile upLoadFile){
        Map<String, Object> map = new HashMap<>();
        try {
            String oldName = upLoadFile.getOriginalFilename();
            String newName = IDUtils.genImageName();
            newName = newName + oldName.substring(oldName.lastIndexOf("."));//拼接后缀名

            //图片上传
            String filePath = new DateTime().toString("/yyyy/MM/dd");
            boolean result = FtpUtil.uploadFile(FTP_ADDRESS, FTP_PORT, FTP_USERNAME, FTP_PASSWORD, FTP_BASE_PATH, filePath, newName, upLoadFile.getInputStream());
            if(!result){
                map.put("error", 1);
                map.put("message", "文件上传服务器失败");
                return map;
            }
            map.put("error", 0);
            map.put("url", IMAGE_BASE_URL + filePath + "/" + newName);
            return map;
        }catch (Exception e){
            map.put("error", 1);
            map.put("message", "文件上传异常 :"+e.getMessage());
            return map;
        }
    }
}
