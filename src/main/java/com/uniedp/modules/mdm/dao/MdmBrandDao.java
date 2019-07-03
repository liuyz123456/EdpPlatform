package com.uniedp.modules.mdm.dao;

import com.uniedp.core.dao.BaseDao;
import com.uniedp.modules.mdm.entity.MdmBrandEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 品牌
 *
 * @author songchen 
 * @since 1.0.0 2019-02-28
 */
@Mapper
public interface MdmBrandDao extends BaseDao<MdmBrandEntity> {
	
}