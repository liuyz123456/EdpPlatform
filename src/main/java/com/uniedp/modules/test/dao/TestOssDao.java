/**
 * Copyright &copy; 2013-2019 山东易科德软件有限公司
 * All rights reserved.
 */
package com.uniedp.modules.test.dao;


import com.uniedp.core.dao.BaseDao;
import com.uniedp.modules.test.entity.TestOssEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * test_oss(测试文件上传业务表)
 * 文件上传Dao
 * @author YJ
 * @since  2019-06-24
 */
@Mapper
public interface TestOssDao extends BaseDao<TestOssEntity> {

}