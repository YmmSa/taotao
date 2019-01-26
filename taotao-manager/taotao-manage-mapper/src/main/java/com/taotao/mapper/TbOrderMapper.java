package com.taotao.mapper;

import com.taotao.common.mapper.BaseMapper;
import com.taotao.pojo.TbOrder;
import com.taotao.pojo.TbOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbOrderMapper extends BaseMapper<TbOrder> {
    int countByExample(TbOrderExample example);

    int deleteByExample(TbOrderExample example);

    List<TbOrder> selectByExample(TbOrderExample example);

    int updateByExampleSelective(@Param("record") TbOrder record, @Param("example") TbOrderExample example);

    int updateByExample(@Param("record") TbOrder record, @Param("example") TbOrderExample example);
}