package com.taotao.mapper;

import com.taotao.common.mapper.BaseMapper;
import com.taotao.pojo.TbUser;
import com.taotao.pojo.TbUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbUserMapper extends BaseMapper<TbUser> {
    int countByExample(TbUserExample example);

    int deleteByExample(TbUserExample example);

    List<TbUser> selectByExample(TbUserExample example);

    int updateByExampleSelective(@Param("record") TbUser record, @Param("example") TbUserExample example);

    int updateByExample(@Param("record") TbUser record, @Param("example") TbUserExample example);
}