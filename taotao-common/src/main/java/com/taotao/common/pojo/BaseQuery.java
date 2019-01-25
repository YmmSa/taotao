package com.taotao.common.pojo;

import java.util.Date;

/**
 * @Auther: aaaa
 * @Date: 2019/1/11 20:57
 * @Description: 查询基类
 */
public abstract class BaseQuery<T> {

    private Long id;

    private Date created;

    private Date updated;

    /** 排序字段 **/
    private String orderField;

    /** 当前页 **/
    private Integer page;

    /** 每页记录数 **/
    private Integer rows;

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }


    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderField() {
        return orderField;
    }

    public void setOrderField(String orderField) {
        this.orderField = orderField;
    }

    public abstract void setQueryCondition(T example);
}
