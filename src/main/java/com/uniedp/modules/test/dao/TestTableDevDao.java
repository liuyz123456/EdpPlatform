/**
 * Copyright &copy; 2013-2019 山东易科德软件有限公司
 * All rights reserved.
 */
package com.uniedp.modules.test.dao;


import com.uniedp.core.dao.BaseDao;
import com.uniedp.modules.test.entity.TestTableDevEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * test_table_dev(测试单表开发)
 * 测试单表开发Dao
 * @author xds
 * @since  2019-05-30
 */
@Mapper
public interface TestTableDevDao extends BaseDao<TestTableDevEntity> {

}