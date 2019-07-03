/**
 * Copyright &copy; 2013-2019 山东易科德软件有限公司
 * All rights reserved.
 */
package com.uniedp.modules.test.dao;


import com.uniedp.core.dao.BaseDao;
import com.uniedp.modules.test.entity.TestTableTreeEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * test_table_tree(测试树表开发)
 * 测试树表开发Dao
 * @author songchen
 * @since  2019-06-18
 */
@Mapper
public interface TestTableTreeDao extends BaseDao<TestTableTreeEntity> {

}