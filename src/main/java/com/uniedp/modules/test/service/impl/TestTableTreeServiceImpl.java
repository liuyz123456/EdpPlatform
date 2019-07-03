/**
 * Copyright &copy; 2013-2019 山东易科德软件有限公司
 * All rights reserved.
 */
package com.uniedp.modules.test.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.uniedp.core.service.impl.CrudServiceImpl;
import com.uniedp.modules.test.dao.TestTableTreeDao;
import com.uniedp.modules.test.dto.TestTableTreeDTO;
import com.uniedp.modules.test.entity.TestTableTreeEntity;
import com.uniedp.modules.test.service.TestTableTreeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;


/**
 * 测试树表操作ServiceImpl
 * @author songchen
 * @version 2019-06-18
 */
@Service
public class TestTableTreeServiceImpl extends CrudServiceImpl<TestTableTreeDao, TestTableTreeEntity, TestTableTreeDTO> implements TestTableTreeService {
    static Long treeRootCode = 0l;

    @Override
    public QueryWrapper<TestTableTreeEntity> getWrapper(Map<String, Object> params){
        QueryWrapper<TestTableTreeEntity> wrapper = new QueryWrapper<>();
        String id = (String)params.get("id");
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);
			Object code=params.get("code");
			if(code!=null){
				wrapper.eq(StringUtils.isNotBlank(code.toString()), "code", code.toString());
			}
			Object name=params.get("name");
			if(name!=null){
				wrapper.like(StringUtils.isNotBlank(name.toString()), "name", name.toString());
			}
        Object id_ne = params.get("id_ne");
        if (id_ne != null) {
            wrapper.ne(StringUtils.isNotBlank(id_ne.toString()), "id", id_ne.toString());
        }
        Object pid_ne = params.get("pid_ne");
        if (pid_ne != null) {
            wrapper.notLike(StringUtils.isNotBlank(pid_ne.toString()), "pids", pid_ne.toString());
        }
        wrapper.orderBy(true, true, "sort");

        return wrapper;
    }

        /**
     * @Description:重写保存方法
     * @Param: [dto]
     * @return: void
     * @Author: songchen
     * @Date:
     */
    @Override
    public void save(TestTableTreeDTO dto) {
        if (dto.getPid() == null) {
            dto.setPid(treeRootCode);
            dto.setPids(treeRootCode.toString());
            dto.setTreeLevel(treeRootCode.intValue() + 1);
        } else {
            //获取父级节点
            TestTableTreeDTO parent = get(dto.getPid());
            //设置树级别
            dto.setTreeLevel(parent.getTreeLevel() + 1);
            dto.setPids(parent.getPids() + "," + parent.getId().toString());
        }
        super.save(dto);
    }

    /**
     * @Description:重写保存方法
     * @Param: [dto]
     * @return: void
     * @Author: songchen
     * @Date:
     */
    @Override
    public void update(TestTableTreeDTO dto) {
        if (dto.getPid() == null) {
            dto.setPid(treeRootCode);
            dto.setPids(treeRootCode.toString());
            dto.setTreeLevel(treeRootCode.intValue() + 1);
        } else {
            if (!dto.getPid().equals(treeRootCode)) {
                //获取修改后的父级节点
                TestTableTreeDTO parent = get(dto.getPid());
                //设置树级别
                dto.setTreeLevel(parent.getTreeLevel() + 1);
                dto.setPids(parent.getPids() + "," + parent.getId().toString());
            } else {
                dto.setTreeLevel(treeRootCode.intValue() + 1);
                dto.setPid(treeRootCode);
                dto.setPids(treeRootCode.toString());
            }
        }
        super.update(dto);
    }

    /**
     * @Description:重写删除方法
     * @Param: [ids]
     * @return: void
     * @Author: songchen
     * @Date:
     */
    @Override
    public void delete(Long[] ids) {
        //重写树表删除 获取第一个id 然后删除本级以及子级
        if (ids.length > 0) {
            Long id = ids[0];
            QueryWrapper<TestTableTreeEntity> wrapper = new QueryWrapper<>();
            wrapper.eq("id", id);
            wrapper.or();
            wrapper.like("pids", id.toString());
            this.baseDao.delete(wrapper);
        }
    }


}