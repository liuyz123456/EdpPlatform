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
 * test_table_dev_child(测试单表开发)
 * 测试子表Entity
 * @author songchen
 * @since  2019-06-20
 */
@Data
@EqualsAndHashCode(callSuper=false)
@TableName("test_table_dev_child")
public class TestTableDevChildEntity extends BaseEntity {
	private static final long serialVersionUID = 1L;
    /**
    * 父级id
    */
    private Long parentId;
    /**
    * 父级编码
    */
    private String parentCode;
    /**
    * 代码
    */
    private String childCode;
    /**
    * 名称
    */
    private String childName;
    /**
    * 生日
    */
    private Date brithday;
    /**
    * 测试下拉
    */
    private String dictTest;
    /**
    * 排序
    */
    private Integer sort;
    /**
    * 测试
    */
    private Boolean flag;
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