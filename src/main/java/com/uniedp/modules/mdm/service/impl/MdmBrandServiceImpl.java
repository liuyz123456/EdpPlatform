package com.uniedp.modules.mdm.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.uniedp.core.service.impl.CrudServiceImpl;
import com.uniedp.modules.mdm.dao.MdmBrandDao;
import com.uniedp.modules.mdm.dto.MdmBrandDTO;
import com.uniedp.modules.mdm.entity.MdmBrandEntity;
import com.uniedp.modules.mdm.service.MdmBrandService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 品牌
 *
 * @author songchen 
 * @since 1.0.0 2019-02-28
 */
@Service
public class MdmBrandServiceImpl extends CrudServiceImpl<MdmBrandDao, MdmBrandEntity, MdmBrandDTO> implements MdmBrandService {

    @Override
    public QueryWrapper<MdmBrandEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<MdmBrandEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);

        return wrapper;
    }


}