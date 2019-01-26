package com.taotao.mapper;

import java.util.List;

import com.fasterxml.jackson.databind.ser.Serializers;
import com.taotao.common.mapper.BaseMapper;
import com.taotao.pojo.TbOrderShipping;
import com.taotao.pojo.TbOrderShippingExample;
import org.apache.ibatis.annotations.Param;

public interface TbOrderShippingMapper extends BaseMapper<TbOrderShipping> {
    int countByExample(TbOrderShippingExample example);

    int deleteByExample(TbOrderShippingExample example);

    List<TbOrderShipping> selectByExample(TbOrderShippingExample example);

    int updateByExampleSelective(@Param("record") TbOrderShipping record, @Param("example") TbOrderShippingExample example);

    int updateByExample(@Param("record") TbOrderShipping record, @Param("example") TbOrderShippingExample example);

}