package com.taotao.pojo;

import com.fasterxml.jackson.databind.ser.Serializers;
import com.taotao.common.pojo.BasePojo;

import java.util.Date;

public class TbItemDesc extends BasePojo {

    private Long itemId;

    private String itemDesc;

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getItemDesc() {
        return itemDesc;
    }

    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc == null ? null : itemDesc.trim();
    }
}