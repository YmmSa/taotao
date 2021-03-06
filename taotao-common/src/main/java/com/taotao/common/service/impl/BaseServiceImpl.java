package com.taotao.common.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.mapper.BaseMapper;
import com.taotao.common.pojo.BasePojo;
import com.taotao.common.pojo.BaseQuery;
import com.taotao.common.pojo.PageResult;
import com.taotao.common.service.BaseService;
import com.taotao.common.utils.DateUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import javax.annotation.PostConstruct;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;

/**
 * @Auther: aaaa
 * @Date: 2019/1/12 22:05
 * @Description:
 */
public class BaseServiceImpl<M extends BaseMapper<T>, T extends BasePojo, Q extends BaseQuery> implements BaseService<T> {

    @Autowired
    ApplicationContext applicationContext;

    protected M mapper;

    @PostConstruct
    public void initMapper(){
        Type genType = getClass().getGenericSuperclass();
        if(genType instanceof ParameterizedType){
            Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
            Class<M> teClass = (Class<M>) params[0];
            this.mapper = applicationContext.getBean(teClass);
        }
    }



    @Override
    public int deleteByPrimaryKey(Long id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public Long insert(T record) {
        setCreatedTime(record);
        setUpdatedDate(record);
        mapper.insert(record);
        return record.getId();
    }

    @Override
    public Long insertSelective(T record) {
        setCreatedTime(record);
        setUpdatedDate(record);
        mapper.insertSelective(record);
        return record.getId();
    }

    @Override
    public T selectByPrimaryKey(Long id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(T record) {
        setUpdatedDate(record);
        return mapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(T record) {
        setUpdatedDate(record);
        return mapper.updateByPrimaryKeySelective(record);
    }

    public void setCreatedTime(T record){
        record.setCreated(DateUtil.getNowDate(DateUtil.DATETIME_FORMAT));
    }

    public void setUpdatedDate(T record){
        record.setUpdated(DateUtil.getNowDate(DateUtil.DATETIME_FORMAT));
    }

    public void setPageQuery(Q query){
        if(query.getPage() != null && query.getRows() != null) {
            PageHelper.startPage(query.getPage(), query.getRows());
        }
        else {
            PageHelper.startPage(1, 30);
        }
        if(StringUtils.isBlank(query.getOrderField())){
            query.setOrderField("updated DESC");
        }
    }

    public PageResult<T> returnPageResult(List<T> lists){
        PageInfo<T> pageInfo = new PageInfo<>(lists);
        PageResult<T> pageResult = new PageResult<>();
        pageResult.setTotal(pageInfo.getTotal());
        pageResult.setRows(pageInfo.getList());
        return pageResult;
    }

}
