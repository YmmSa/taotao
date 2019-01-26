package com.taotao.service;

import com.taotao.common.pojo.PageResult;
import com.taotao.common.service.BaseService;
import com.taotao.common.utils.TaotaoResult;
import com.taotao.pojo.TbItem;
import com.taotao.query.TbItemQuery;
import org.apache.commons.lang3.StringUtils;

/**
 * @Auther: aaaa
 * @Date: 2019/1/6 16:22
 * @Description:
 */
public interface TbItemService extends BaseService<TbItem> {
    public PageResult<TbItem> findPage(TbItemQuery query);

    public TaotaoResult createTbItem(TbItem item, String desc);
}
