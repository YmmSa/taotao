package com.taotao.controller;

import com.taotao.common.pojo.PageResult;
import com.taotao.pojo.TbItem;
import com.taotao.query.TbItemQuery;
import com.taotao.service.TbItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @Auther: aaaa
 * @Date: 2019/1/9 20:23
 * @Description:
 */
@Controller
public class TbItemController {

    @Autowired
    TbItemService itemService;

    @RequestMapping("/item/{itemId}")
    @ResponseBody
    public TbItem getItemById(@PathVariable Long itemId){
        return itemService.getTbItemById(itemId);
    }

    @RequestMapping(value = "/item/list", method = RequestMethod.POST)
    @ResponseBody
    //EasyUIDataGrid传的参数是用?&跟在url后的，@RequestBody是用来处理json字符串的，不能加
    public PageResult<TbItem> getItemById(TbItemQuery query){
        return itemService.findPage(query);
    }

}
