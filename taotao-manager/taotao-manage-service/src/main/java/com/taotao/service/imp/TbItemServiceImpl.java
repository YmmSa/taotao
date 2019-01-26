package com.taotao.service.imp;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.pojo.PageResult;
import com.taotao.common.service.impl.BaseServiceImpl;
import com.taotao.common.utils.TaotaoResult;
import com.taotao.enu.ITEM_STATUS;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemDesc;
import com.taotao.pojo.TbItemExample;
import com.taotao.query.TbItemQuery;
import com.taotao.service.TbItemDescService;
import com.taotao.service.TbItemService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: aaaa
 * @Date: 2019/1/6 16:38
 * @Description:
 */
@Service
public class TbItemServiceImpl extends BaseServiceImpl<TbItemMapper, TbItem> implements TbItemService {

    @Autowired
    private TbItemDescService itemDescService;

    @Override
    public PageResult<TbItem> findPage(TbItemQuery query) {
        if(query.getPage() != null && query.getRows() != null) {
            PageHelper.startPage(query.getPage(), query.getRows());
        }
        else {
            PageHelper.startPage(1, 30);
        }
        if(StringUtils.isBlank(query.getOrderField())){
            query.setOrderField("updated DESC");
        }
        TbItemExample example = new TbItemExample();
        query.setQueryCondition(example);

        List<TbItem> itemList = mapper.selectByExample(example);
        PageInfo<TbItem> pageInfo = new PageInfo<>(itemList);
        PageResult<TbItem> pageResult = new PageResult<>();
        pageResult.setTotal(pageInfo.getTotal());
        pageResult.setRows(pageInfo.getList());
        return pageResult;
    }

    @Override
    public TaotaoResult createTbItem(TbItem item, String desc) {
        item.setStatus(ITEM_STATUS.NORMAL.getValue());
        long id = this.insertSelective(item);

        //插入商品描述
        insertItemDesc(id, desc);
        
        return TaotaoResult.ok();
    }

    private void insertItemDesc(Long itemId, String desc){
        TbItemDesc itemDesc = new TbItemDesc();
        itemDesc.setItemId(itemId);
        itemDesc.setItemDesc(desc);
        itemDescService.insertSelective(itemDesc);
    }
}
