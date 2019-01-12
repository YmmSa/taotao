package com.taotao.service.imp;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.pojo.PageResult;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;
import com.taotao.query.TbItemQuery;
import com.taotao.service.TbItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;

/**
 * @Auther: aaaa
 * @Date: 2019/1/6 16:38
 * @Description:
 */
@Service
public class TbItemServiceImpl implements TbItemService {

    @Autowired
    TbItemMapper mapper;

    @Override
    public TbItem getTbItemById(Long id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public PageResult<TbItem> findPage(TbItemQuery query) {
        if(query.getPage() != null && query.getRows() != null) {
            PageHelper.startPage(query.getPage(), query.getRows());
        }
        else {
            PageHelper.startPage(1, 30);
        }
        TbItemExample example = new TbItemExample();
        TbItemExample.Criteria criteria = example.createCriteria();

        query.setQueryCondition(criteria);

        List<TbItem> itemList = mapper.selectByExample(example);
        PageInfo<TbItem> pageInfo = new PageInfo<>(itemList);
        PageResult<TbItem> pageResult = new PageResult<>();
        pageResult.setTotal(pageInfo.getTotal());
        pageResult.setRows(pageInfo.getList());
        return pageResult;
    }
}
