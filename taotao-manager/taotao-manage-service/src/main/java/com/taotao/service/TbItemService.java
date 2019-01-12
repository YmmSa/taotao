package com.taotao.service;

import com.taotao.common.pojo.PageResult;
import com.taotao.pojo.TbItem;
import com.taotao.query.TbItemQuery;

/**
 * @Auther: aaaa
 * @Date: 2019/1/6 16:22
 * @Description:
 */
public interface TbItemService {
    public TbItem getTbItemById(Long id);

    public PageResult<TbItem> findPage(TbItemQuery query);
}
