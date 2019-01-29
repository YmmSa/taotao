package com.taotao.service.imp;

import com.taotao.common.service.impl.BaseServiceImpl;
import com.taotao.mapper.TbItemDescMapper;
import com.taotao.pojo.TbItemDesc;
import com.taotao.query.TbItemDescQuery;
import com.taotao.service.TbItemDescService;
import org.springframework.stereotype.Service;

/**
 * @Auther: aaaa
 * @Date: 2019/1/25 22:29
 * @Description:
 */
@Service
public class TbItemDescServiceImpl extends BaseServiceImpl<TbItemDescMapper, TbItemDesc, TbItemDescQuery> implements TbItemDescService {
}
