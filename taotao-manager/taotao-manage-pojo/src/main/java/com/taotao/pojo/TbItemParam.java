package com.taotao.pojo;

import com.taotao.common.pojo.BasePojo;

import java.util.Date;

public class TbItemParam extends BasePojo {

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
}