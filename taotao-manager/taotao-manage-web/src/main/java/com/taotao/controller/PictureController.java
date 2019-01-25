package com.taotao.controller;

import com.taotao.common.utils.JsonUtils;
import com.taotao.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * @Auther: aaaa
 * @Date: 2019/1/19 15:10
 * @Description:
 */
@Controller
@RequestMapping("/pic")
public class PictureController {

    @Autowired
    private PictureService pictureService;

    @RequestMapping("/upload")
    @ResponseBody
    public String upload(MultipartFile uploadFile) {
        //调用service上传图片
        Map<String, Object> map = pictureService.upLoadPicture(uploadFile);
        //返回上传结果,用String浏览器兼容性更好
        return JsonUtils.objectToJson(map);
    }
}
