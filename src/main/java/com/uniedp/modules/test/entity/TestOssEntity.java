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
 * test_oss(测试文件上传业务表)
 * 文件上传Entity
 * @author YJ
 * @since  2019-06-24
 */
@Data
@EqualsAndHashCode(callSuper=false)
@TableName("test_oss")
public class TestOssEntity extends BaseEntity {
	private static final long serialVersionUID = 1L;
    /**
    * 测试业务名
    */
    private String name;
    /**
    * 更新者
    */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String updater;
    /**
    * 更新时间
    */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateDate;
}