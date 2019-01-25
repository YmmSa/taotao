package com.taotao.controller;

import com.taotao.pojo.TbItemCat;
import com.taotao.service.TbItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: aaaa
 * @Date: 2019/1/13 15:37
 * @Description:
 */
@Controller
@RequestMapping("/item/cat")
public class TbItemCatController {

    @Autowired
    TbItemCatService itemCatService;

    @RequestMapping("/list")
    @ResponseBody
    public List<Map<String, Object>> listItemCat(@RequestParam(value = "id", defaultValue = "0") long parentId){
        List<TbItemCat> itemCats = itemCatService.getItemCatList(parentId);

        List<Map<String,Object>> itemCatList = new ArrayList<>();
        Map<String, Object> node;
        for(TbItemCat itemCat: itemCats){
            node = new HashMap<>();
            node.put("id", itemCat.getId());
            node.put("text", itemCat.getName());
            node.put("state", itemCat.getIsParent() ? "closed" : "open");
            itemCatList.add(node);
        }
        return itemCatList;
    }

}
