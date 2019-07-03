/**
 * Copyright &copy; 2013-2019 山东易科德软件有限公司
 * All rights reserved.
 */
package com.uniedp.modules.test.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.uniedp.core.service.impl.CrudServiceImpl;
import com.uniedp.modules.test.dao.TestTableDevChildDao;
import com.uniedp.modules.test.dto.TestTableDevChildDTO;
import com.uniedp.modules.test.entity.TestTableDevChildEntity;
import com.uniedp.modules.test.service.TestTableDevChildService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;


/**
 * 测试单表操作ServiceImpl
 *
 * @author songchen
 * @version 2019-06-20
 */
@Service
public class TestTableDevChildServiceImpl extends CrudServiceImpl<TestTableDevChildDao, TestTableDevChildEntity, TestTableDevChildDTO> implements TestTableDevChildService {

    @Override
    public QueryWrapper<TestTableDevChildEntity> getWrapper(Map<String, Object> params) {

        QueryWrapper<TestTableDevChildEntity> wrapper = new QueryWrapper<>();
        String id = (String) params.get("id");
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);
        Object parentCode = params.get("parentCode");
        if (parentCode != null) {
            wrapper.eq(StringUtils.isNotBlank(parentCode.toString()), "parent_code", parentCode.toString());
        }
        Object parentId = params.get("parentId");
        if (parentId != null) {
            wrapper.eq(StringUtils.isNotBlank(parentId.toString()), "parent_id", parentId.toString());
        }
        Object childCode = params.get("childCode");
        if (childCode != null) {
            wrapper.eq(StringUtils.isNotBlank(childCode.toString()), "child_code", childCode.toString());
        }
        Object childName = params.get("childName");
        if (childName != null) {
            wrapper.eq(StringUtils.isNotBlank(childName.toString()), "child_name", childName.toString());
        }

        return wrapper;
    }

    /**
     * @Description: 根据主表ID 删除子表相关数据
     * @Param: [ids]
     * @return: void
     * @Author: songchen
     * @Date: 2019-06-20
     */
    @Override
    public void deltByParentIds(Long[] ids) {
        QueryWrapper<TestTableDevChildEntity> wrapper = new QueryWrapper<>();
        wrapper.in("parent_id", ids);
        this.baseDao.delete(wrapper);
    }

}