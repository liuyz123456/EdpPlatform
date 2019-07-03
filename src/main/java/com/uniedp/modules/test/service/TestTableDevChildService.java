/**
 * Copyright &copy; 2013-2019 山东易科德软件有限公司
 * All rights reserved.
 */
package com.uniedp.modules.test.service;

import java.util.List;


import com.uniedp.core.service.CrudService;
import com.uniedp.modules.test.dto.TestTableDevChildDTO;
import com.uniedp.modules.test.entity.TestTableDevChildEntity;


/**
 * 测试单表操作Service
 * @author songchen
 * @version 2019-06-20
 */
public interface TestTableDevChildService extends CrudService<TestTableDevChildEntity, TestTableDevChildDTO> {
     /**
     * @Description: 根据主表ID 删除子表相关数据
     * @Param: [ids]
     * @return: void
     * @Author: songchen
     * @Date: 2019-06-20
     */
     public void deltByParentIds(Long[] ids);
}