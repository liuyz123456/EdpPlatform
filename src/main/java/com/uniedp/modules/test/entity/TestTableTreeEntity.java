/**
 * Copyright &copy; 2013-2019 山东易科德软件有限公司
 * All rights reserved.
 */
package com.uniedp.modules.test.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.uniedp.core.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * test_table_tree(测试树表开发)
 * 测试树表操作Entity
 * @author songchen
 * @since  2019-06-18
 */
@Data
@EqualsAndHashCode(callSuper=false)
@TableName("test_table_tree")
public class TestTableTreeEntity extends BaseEntity {
	private static final long serialVersionUID = 1L;
    /**
    * 代码
    */
    private String code;
    /**
    * 名称
    */
    private String name;
    /**
    * 父级编码
    */
    private Long pid;
    /**
    * 所有父级编码
    */
    private String pids;
    /**
    * 图标
    */
    private String icon;
    /**
    * 级别
    */
    private Integer treeLevel;
    /**
    * 备注
    */
    private String remarks;
    /**
    * 排序
    */
    private Integer sort;
    /**
    * 状态
    */
    private Integer status;
    /**
    * 更新时间(YYYY-MM-DD HH:MM:SS)
    */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String updater;
    /**
    * 更新人
    */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateDate;
}