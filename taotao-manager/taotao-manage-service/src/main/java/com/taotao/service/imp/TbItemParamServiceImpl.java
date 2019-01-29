package com.taotao.service.imp;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.pojo.PageResult;
import com.taotao.common.service.impl.BaseServiceImpl;
import com.taotao.common.utils.TaotaoResult;
import com.taotao.mapper.TbItemParamMapper;
import com.taotao.pojo.TbItemParam;
import com.taotao.pojo.TbItemParamExample;
import com.taotao.query.TbItemParamQuery;
import com.taotao.service.TbItemParamService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: aaaa
 * @Date: 2019/1/26 17:53
 * @Description:
 */
@Service
public class TbItemParamServiceImpl extends BaseServiceImpl<TbItemParamMapper, TbItemParam, TbItemParamQuery> implements TbItemParamService {
    @Override
    public PageResult<TbItemParam> findPage(TbItemParamQuery query) {
        setPageQuery(query);
        TbItemParamExample example = new TbItemParamExample();
        query.setQueryCondition(example);

        List<TbItemParam> itemParamList = mapper.selectByExample(example);
        return returnPageResult(itemParamList);
    }

    @Override
    public TaotaoResult createTbItemParam(TbItemParam itemParam) {
        return null;
    }

    @Override
    public TaotaoResult findByItemCatId(long itemCatId) {
        TbItemParamExample example = new TbItemParamExample();
        TbItemParamExample.Criteria criteria = example.createCriteria();
        criteria.andItemCatIdEqualTo(itemCatId);
        List<TbItemParam> itemParamList = mapper.selectByExample(example);
        if(itemParamList == null || itemParamList.size() == 0){
            return TaotaoResult.ok();
        }
        return TaotaoResult.ok(itemParamList.get(0));
    }

    @Override
    public TaotaoResult createItemParam(long cid, String paramData) {
        TbItemParam itemParam = new TbItemParam();
        itemParam.setItemCatId(cid);
        itemParam.setParamData(paramData);
        this.insertSelective(itemParam);
        return TaotaoResult.ok();
    }

    @Override
    public void delete(long id) {
        mapper.deleteByPrimaryKey(id);
    }
}
