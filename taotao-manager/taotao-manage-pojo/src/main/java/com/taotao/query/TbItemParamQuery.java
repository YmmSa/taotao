package com.taotao.query;

import com.taotao.common.pojo.BaseQuery;
import com.taotao.pojo.TbItemParam;
import com.taotao.pojo.TbItemParamExample;

/**
 * @Auther: aaaa
 * @Date: 2019/1/26 17:39
 * @Description:
 */
public class TbItemParamQuery extends BaseQuery<TbItemParamExample> {

    private Long itemCatId;

    private String paramData;

    public Long getItemCatId() {
        return itemCatId;
    }

    public void setItemCatId(Long itemCatId) {
        this.itemCatId = itemCatId;
    }

    public String getParamData() {
        return paramData;
    }

    public void setParamData(String paramData) {
        this.paramData = paramData == null ? null : paramData.trim();
    }

    @Override
    public void setQueryCondition(TbItemParamExample example) {
        TbItemParamExample.Criteria criteria = example.createCriteria();
        if (this.getId() != null){
            criteria.andIdEqualTo(this.getId());
        }
        if(this.getCreated() != null){
            criteria.andCreatedEqualTo(this.getCreated());
        }
        if(this.getUpdated() != null){
            criteria.andUpdatedEqualTo(this.getUpdated());
        }
        if(this.getItemCatId() != null){
            criteria.andItemCatIdEqualTo(this.getItemCatId());
        }
    }
}
