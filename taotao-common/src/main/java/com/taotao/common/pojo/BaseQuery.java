package com.taotao.common.pojo;

/**
 * @Auther: aaaa
 * @Date: 2019/1/11 20:57
 * @Description: 查询基类
 */
public abstract class BaseQuery<T> {

    /** 当前页 **/
    private Integer page;

    /** 每页记录数 **/
    private Integer rows;

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

    public abstract void setQueryCondition(T example);
}
