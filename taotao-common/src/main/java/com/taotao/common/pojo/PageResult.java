package com.taotao.common.pojo;

import java.util.List;

/**
 * @Auther: aaaa
 * @Date: 2019/1/11 20:55
 * @Description:用于EasyUIDataGrid 分页
 */
public class PageResult<T> {

    /** 总条数 **/
    private Long total;

    private List<T> rows;

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }


}
