/**
 * Copyright &copy; 2013-2019 山东易科德软件有限公司
 * All rights reserved.
 */
package com.uniedp.modules.test.dao;


import com.uniedp.core.dao.BaseDao;
import com.uniedp.modules.test.entity.TestTableDevChildEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * test_table_dev_child(测试单表开发)
 * 字表生成Dao
 * @author ste
 * @since  2019-06-05
 */
@Mapper
public interface TestTableDevChildDao extends BaseDao<TestTableDevChildEntity> {

}