/**
 * Copyright &copy; 2013-2019 山东易科德软件有限公司
 * All rights reserved.
 */
package com.uniedp.modules.test.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.uniedp.core.service.impl.CrudServiceImpl;
import com.uniedp.modules.test.dao.TestTableDevDao;
import com.uniedp.modules.test.dto.TestTableDevChildDTO;
import com.uniedp.modules.test.dto.TestTableDevDTO;
import com.uniedp.modules.test.entity.TestTableDevEntity;
import com.uniedp.modules.test.service.TestTableDevChildService;
import com.uniedp.modules.test.service.TestTableDevService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Map;


/**
 * 父表管理功能ServiceImpl
 *
 * @author sss
 * @version 2019-06-20
 */
@Service
public class TestTableDevServiceImpl extends CrudServiceImpl<TestTableDevDao, TestTableDevEntity, TestTableDevDTO> implements TestTableDevService {
    @Resource
    TestTableDevChildService testTableDevChildService;

    @Override
    public QueryWrapper<TestTableDevEntity> getWrapper(Map<String, Object> params) {

        QueryWrapper<TestTableDevEntity> wrapper = new QueryWrapper<>();
        String id = (String) params.get("id");
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);
        Object code = params.get("code");
        if (code != null) {
            wrapper.eq(StringUtils.isNotBlank(code.toString()), "code", code.toString());
        }
        Object name = params.get("name");
        if (name != null) {
            wrapper.like(StringUtils.isNotBlank(name.toString()), "name", name.toString());
        }
        Object mobile = params.get("mobile");
        if (mobile != null) {
            wrapper.eq(StringUtils.isNotBlank(mobile.toString()), "mobile", mobile.toString());
        }
        Object phone = params.get("phone");
        if (phone != null) {
            wrapper.eq(StringUtils.isNotBlank(phone.toString()), "phone", phone.toString());
        }

        return wrapper;
    }

    /**
     * @Description: 重写主表保存
     * @Param: [ids]
     * @return: void
     * @Author: songchen
     * @Date: 2019-06-20
     */
    @Override
    @Transactional
    public void save(TestTableDevDTO dto) {
        super.save(dto);
        for (TestTableDevChildDTO child : dto.getChildren()) {
            child.setParentId(dto.getId());
            child.setParentCode(dto.getCode());
            testTableDevChildService.save(child);
        }
    }

    /**
     * @Description: 重写主表修改
     * @Param: [ids]
     * @return: void
     * @Author: songchen
     * @Date: 2019-06-20
     */
    @Override
    @Transactional
    public void update(TestTableDevDTO dto) {
        super.update(dto);
        //先 删除子表
        for (TestTableDevChildDTO child : dto.getDeltList()) {
            testTableDevChildService.deleteById(child.getId());
        }
        //二 新增子表
        for (TestTableDevChildDTO child : dto.getChildren()) {
            if (child.getId() == null) {
                child.setParentId(dto.getId());
                child.setParentCode(dto.getCode());
                testTableDevChildService.save(child);
            }
        }
        //三 修改子表
        for (TestTableDevChildDTO child : dto.getChildren()) {
            if (child.getId() != null) {
                testTableDevChildService.update(child);
            }
        }
    }

    /**
     * @Description: 重写主表删除
     * @Param: [ids]
     * @return: void
     * @Author: songchen
     * @Date: 2019-06-20
     */
    @Override
    @Transactional
    public void delete(Long[] ids) {
        super.delete(ids);
        testTableDevChildService.deltByParentIds(ids);
    }

}