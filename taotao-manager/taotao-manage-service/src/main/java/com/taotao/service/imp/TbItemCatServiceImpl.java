package com.taotao.service.imp;

import com.taotao.common.service.impl.BaseServiceImpl;
import com.taotao.mapper.TbItemCatMapper;
import com.taotao.pojo.TbItemCat;
import com.taotao.pojo.TbItemCatExample;
import com.taotao.query.TbItemCatQuery;
import com.taotao.service.TbItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: aaaa
 * @Date: 2019/1/13 15:31
 * @Description:
 */
@Service
public class TbItemCatServiceImpl extends BaseServiceImpl<TbItemCatMapper, TbItemCat, TbItemCatQuery> implements TbItemCatService {

    @Override
    public List<TbItemCat> getItemCatList(Long parentId) {
        TbItemCatExample example = new TbItemCatExample();
        TbItemCatExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(parentId);
        List<TbItemCat> itemCats = mapper.selectByExample(example);
        return itemCats;
    }
}
