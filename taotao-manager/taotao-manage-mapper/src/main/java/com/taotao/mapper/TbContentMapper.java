package com.taotao.mapper;

import com.taotao.common.mapper.BaseMapper;
import com.taotao.pojo.TbContent;
import com.taotao.pojo.TbContentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbContentMapper extends BaseMapper<TbContent> {
    int countByExample(TbContentExample example);

    int deleteByExample(TbContentExample example);

    List<TbContent> selectByExampleWithBLOBs(TbContentExample example);

    List<TbContent> selectByExample(TbContentExample example);

    int updateByExampleSelective(@Param("record") TbContent record, @Param("example") TbContentExample example);

    int updateByExampleWithBLOBs(@Param("record") TbContent record, @Param("example") TbContentExample example);

    int updateByExample(@Param("record") TbContent record, @Param("example") TbContentExample example);

    int updateByPrimaryKeyWithBLOBs(TbContent record);
}