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
 * test_table_dev(测试单表开发)
 * ddddEntity
 * @author sss
 * @since  2019-06-04
 */
@Data
@EqualsAndHashCode(callSuper=false)
@TableName("test_table_dev")
public class TestTableDevEntity extends BaseEntity {
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
    * 年龄
    */
    private Long age;
    /**
    * 邮箱
    */
    private String email;
    /**
    * 生日
    */
    private Date brithday;
    /**
    * 手机号
    */
    private String mobile;
    /**
    * 电话号码
    */
    private String phone;
    /**
    * 个人主页
    */
    private String url;
    /**
    * 排序
    */
    private Long sort;
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