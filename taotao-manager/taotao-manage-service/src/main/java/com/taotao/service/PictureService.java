package com.taotao.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

/**
 * @Auther: aaaa
 * @Date: 2019/1/15 20:51
 * @Description:
 */
public interface PictureService {
    Map<String, Object> upLoadPicture(MultipartFile multipartFile);
}
