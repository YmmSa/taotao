package com.taotao.service.imp;

import com.taotao.common.service.impl.BaseServiceImpl;
import com.taotao.common.utils.JsonUtils;
import com.taotao.mapper.TbItemParamItemMapper;
import com.taotao.pojo.TbItemParamItem;
import com.taotao.pojo.TbItemParamItemExample;
import com.taotao.query.TbItemParamItemQuery;
import com.taotao.service.TbItemParamItemService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


/**
 * @Auther: aaaa
 * @Date: 2019/1/29 20:59
 * @Description:
 */
@Service
public class TbItemParamItemServiceImpl extends BaseServiceImpl<TbItemParamItemMapper, TbItemParamItem, TbItemParamItemQuery> implements TbItemParamItemService {
    @Override
    public void createItemParamItem(TbItemParamItem itemParamItem) {

    }

    @Override
    public String selectByTbItemId(Long tbItemId) {

        TbItemParamItemExample example = new TbItemParamItemExample();
        TbItemParamItemExample.Criteria criteria = example.createCriteria();
        criteria.andItemIdEqualTo(tbItemId);
        List<TbItemParamItem> list = mapper.selectByExampleWithBLOBs(example);
        if(list == null || list.size() == 0){
            return "";
        }
        String paramData = list.get(0).getParamData();
        //生成html
        // 把规格参数json数据转换成java对象
        List<Map> jsonList = JsonUtils.jsonToList(paramData, Map.class);
        StringBuffer sb = new StringBuffer();
        sb.append("<table cellpadding=\"0\" cellspacing=\"1\" width=\"100%\" border=\"1\" class=\"Ptable\">\n");
        sb.append("    <tbody>\n");
        for(Map m1:jsonList) {
            sb.append("        <tr>\n");
            sb.append("            <th class=\"tdTitle\" colspan=\"2\">"+m1.get("group")+"</th>\n");
            sb.append("        </tr>\n");
            List<Map> list2 = (List<Map>) m1.get("params");
            for(Map m2:list2) {
                sb.append("        <tr>\n");
                sb.append("            <td class=\"tdTitle\">"+m2.get("k")+"</td>\n");
                sb.append("            <td>"+m2.get("v")+"</td>\n");
                sb.append("        </tr>\n");
            }
        }
        sb.append("    </tbody>\n");
        sb.append("</table>");
        return sb.toString();
    }
}
