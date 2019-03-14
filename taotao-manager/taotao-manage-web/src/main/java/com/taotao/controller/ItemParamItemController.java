package com.taotao.controller;

import com.taotao.service.TbItemParamItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Auther: aaaa
 * @Date: 2019/3/14 22:36
 * @Description:
 */
@Controller
public class ItemParamItemController {

    @Autowired
    private TbItemParamItemService itemParamItemService;

    @RequestMapping("/showItem/{itemId}")
    public String showItemParam(@PathVariable Long itemId, Model model) {
        String string = itemParamItemService.selectByTbItemId(itemId);
        model.addAttribute("itemParam", string);
        return "item";
    }
}
