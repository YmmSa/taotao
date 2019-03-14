package com.taotao.service;

import com.taotao.common.service.BaseService;
import com.taotao.pojo.TbItemParam;
import com.taotao.pojo.TbItemParamItem;

/**
 * @Auther: aaaa
 * @Date: 2019/1/29 20:57
 * @Description:
 */
public interface TbItemParamItemService extends BaseService<TbItemParamItem> {
    public void createItemParamItem(TbItemParamItem itemParamItem);

    public String selectByTbItemId(Long tbItemId);
}
