package com.taotao.query;

import com.fasterxml.jackson.databind.ser.Serializers;
import com.taotao.common.pojo.BaseQuery;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;

/**
 * @Auther: aaaa
 * @Date: 2019/1/11 21:04
 * @Description:
 */
public class TbItemQuery extends BaseQuery<TbItemExample> {

    private String title;

    private String sellPoint;

    private Long price;

    private Integer num;

    private String barcode;

    private String image;

    private Long cid;

    private Byte status;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getSellPoint() {
        return sellPoint;
    }

    public void setSellPoint(String sellPoint) {
        this.sellPoint = sellPoint == null ? null : sellPoint.trim();
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode == null ? null : barcode.trim();
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    @Override
    public void setQueryCondition(TbItemExample example) {
        TbItemExample.Criteria criteria = example.createCriteria();
        if(this.getId() != null) {
            criteria.andIdEqualTo(this.getId());
        }
        if(this.title != null && this.title != "") {
            criteria.andTitleEqualTo(this.title);
        }
        if(this.sellPoint != null && this.sellPoint != "") {
            criteria.andSellPointEqualTo(this.sellPoint);
        }
        if(this.price != null) {
            criteria.andPriceEqualTo(this.price);
        }
        if(this.num != null) {
            criteria.andNumEqualTo(this.num);
        }
        if(this.barcode != null && this.barcode != "") {
            criteria.andBarcodeEqualTo(this.barcode);
        }
        if(this.image != null && this.image != "") {
            criteria.andImageEqualTo(this.image);
        }
        if(this.getCreated() != null) {
            criteria.andCreatedEqualTo(this.getCreated());
        }
        if(this.getUpdated() != null) {
            criteria.andUpdatedEqualTo(this.getUpdated());
        }
        if(StringUtils.isNotBlank(this.getOrderField())){
            example.setOrderByClause(this.getOrderField());
        }
    }
}
