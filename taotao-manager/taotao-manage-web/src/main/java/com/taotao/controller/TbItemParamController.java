package com.taotao.controller;

import com.taotao.common.pojo.PageResult;
import com.taotao.common.utils.TaotaoResult;
import com.taotao.pojo.TbItemParam;
import com.taotao.query.TbItemParamQuery;
import com.taotao.service.TbItemParamService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Auther: aaaa
 * @Date: 2019/1/26 17:38
 * @Description:
 */
@Controller
@RequestMapping("/item/param")
public class TbItemParamController {

    @Autowired
    private TbItemParamService itemParamService;

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    //EasyUIDataGrid传的参数是用?&跟在url后的，@RequestBody是用来处理json字符串的，不能加
    public PageResult<TbItemParam> list(TbItemParamQuery query){
        return itemParamService.findPage(query);
    }

    @RequestMapping(value = "/query/itemCatId", method = RequestMethod.POST)
    @ResponseBody
    public TaotaoResult findByItemCatId(@Param("id") Long itemCatId){
        return itemParamService.findByItemCatId(itemCatId);
    }

    @RequestMapping(value = "/save/{cid}", method = RequestMethod.POST)
    @ResponseBody
    public TaotaoResult save(@PathVariable("cid") Long cid, String paramData){
        return itemParamService.createItemParam(cid, paramData);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public TaotaoResult delete(String ids){
        String[] idStr = ids.split(",");
        for(int i=0, len=idStr.length; i<len; i++){
            itemParamService.delete(Long.parseLong(idStr[i]));
        }
        return TaotaoResult.ok();
    }

}
