package com.taotao.pojo;

import com.taotao.common.pojo.BasePojo;

import java.util.Date;

public class TbItemParamItem extends BasePojo {

    private Long itemId;

    private String paramData;

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getParamData() {
        return paramData;
    }

    public void setParamData(String paramData) {
        this.paramData = paramData == null ? null : paramData.trim();
    }
}