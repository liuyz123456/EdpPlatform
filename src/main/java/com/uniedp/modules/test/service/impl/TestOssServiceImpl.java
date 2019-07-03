/**
 * Copyright &copy; 2013-2019 山东易科德软件有限公司
 * All rights reserved.
 */
package com.uniedp.modules.test.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.uniedp.core.service.impl.CrudServiceImpl;
import com.uniedp.modules.oss.dto.SysOssDTO;
import com.uniedp.modules.oss.entity.SysOssEntity;
import com.uniedp.modules.oss.service.SysOssService;
import com.uniedp.modules.test.dao.TestOssDao;
import com.uniedp.modules.test.dto.TestOssDTO;
import com.uniedp.modules.test.entity.TestOssEntity;
import com.uniedp.modules.test.service.TestOssService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;


/**
 * 文件上传ServiceImpl
 *
 * @author YJ
 * @version 2019-06-24
 */
@Service
public class TestOssServiceImpl extends CrudServiceImpl<TestOssDao, TestOssEntity, TestOssDTO> implements TestOssService {

    @Autowired
    private SysOssService sysOssService;

    @Override
    public QueryWrapper<TestOssEntity> getWrapper(Map<String, Object> params) {

        QueryWrapper<TestOssEntity> wrapper = new QueryWrapper<>();
        String id = (String) params.get("id");
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);
        Object name = params.get("name");
        if (name != null) {
            wrapper.like(StringUtils.isNotBlank(name.toString()), "name", name.toString());
        }

        return wrapper;
    }

    @Override
    public TestOssDTO get(Long id) {
        TestOssDTO dto = super.get(id);

        List<Map<String, Object>> list = sysOssService.getMapByBizId(id);

        dto.setFileList(getFileList(list, "HT01"));
        dto.setFileList1(getFileList(list, "HT02"));
        dto.setFileList2(getFileList(list, "HT03"));

        return dto;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void save(TestOssDTO dto) {
        super.save(dto);
        updateBizId(dto);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void update(TestOssDTO dto) {
        super.update(dto);
        updateBizId(dto);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(Long[] ids) {
        super.delete(ids);
        sysOssService.deleteByBizId(ids);
    }

    private void updateBizId(TestOssDTO dto) {
        List<Long> ossIdList = Lists.newArrayList();
        int size = dto.getFileList().size() + dto.getFileList1().size() + dto.getFileList2().size();
        Long[] ids = new Long[size];
        for (Map map : dto.getFileList()) {
            ossIdList.add(Long.valueOf(map.get("id").toString()));
        }
        for (Map map : dto.getFileList1()) {
            ossIdList.add(Long.valueOf(map.get("id").toString()));
        }
        for (Map map : dto.getFileList2()) {
            ossIdList.add(Long.valueOf(map.get("id").toString()));
        }
        ossIdList.toArray(ids);
        sysOssService.updateBizId(ids, dto.getId());
    }

    private List<Map<String, Object>> getFileList(List<Map<String, Object>> list, String dirValue) {
        List<Map<String, Object>> temp = Lists.newArrayList();
        for (Map<String, Object> map : list) {
            if (map.get("dirValue").equals(dirValue)) {
                temp.add(map);
            }
        }
        return temp;
    }
}