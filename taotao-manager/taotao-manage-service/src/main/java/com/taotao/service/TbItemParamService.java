package com.taotao.service;

import com.taotao.common.pojo.PageResult;
import com.taotao.common.service.BaseService;
import com.taotao.common.utils.TaotaoResult;
import com.taotao.pojo.TbItemParam;
import com.taotao.query.TbItemParamQuery;

/**
 * @Auther: aaaa
 * @Date: 2019/1/26 17:51
 * @Description:
 */
public interface TbItemParamService extends BaseService<TbItemParam> {
    public PageResult<TbItemParam> findPage(TbItemParamQuery query);

    public TaotaoResult createTbItemParam(TbItemParam itemParam);

    public TaotaoResult findByItemCatId(long itemCatId);

    public TaotaoResult createItemParam(long cid, String paramData);

    public void delete(long id);
}
