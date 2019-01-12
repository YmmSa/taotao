package com.taotao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Auther: aaaa
 * @Date: 2019/1/10 20:15
 * @Description:
 */
@Controller
public class PageController {

    /**
     * 打开首页
     * @return
     */
    @RequestMapping("/")
    public String showIndex(){
        return "index";
    }



    /**
     * 页码跳转
     * @return
     */
    @RequestMapping("/{page}")
    public String showPage(@PathVariable String page){
        return page;
    }
}
