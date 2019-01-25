package com.taotao.service;

import com.taotao.common.service.BaseService;
import com.taotao.pojo.TbItemCat;

import java.util.List;

/**
 * @Auther: aaaa
 * @Date: 2019/1/13 15:29
 * @Description:
 */
public interface TbItemCatService extends BaseService<TbItemCat> {
    public List<TbItemCat> getItemCatList(Long parentId);
}
