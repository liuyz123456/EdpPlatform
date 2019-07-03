/**
 * Copyright &copy; 2013-2019 山东易科德软件有限公司
 * All rights reserved.
 */
package com.uniedp.modules.test.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;


import java.util.Date;

/**
 * test_table_dev_child(测试单表开发)
 * 测试子表Excel
 * @author songchen
 * @since  2019-06-20
 */
@Data
public class TestTableDevChildExcel {
	private static final long serialVersionUID = 1L;
    /**
    * id
    */
    @Excel(name = "id")
    private Long id;
    /**
    * 父级id
    */
    @Excel(name = "父级id")
    private Long parentId;
    /**
    * 父级编码
    */
    @Excel(name = "父级编码")
    private String parentCode;
    /**
    * 代码
    */
    @Excel(name = "代码")
    private String childCode;
    /**
    * 名称
    */
    @Excel(name = "名称")
    private String childName;
    /**
    * 生日
    */
    @Excel(name = "生日")
    private Date brithday;
    /**
    * 测试下拉
    */
    @Excel(name = "测试下拉")
    private String dictTest;
    /**
    * 排序
    */
    @Excel(name = "排序")
    private Integer sort;
    /**
    * 测试
    */
    @Excel(name = "测试")
    private Integer flag;
    /**
    * 状态
    */
    @Excel(name = "状态")
    private Integer status;
    /**
    * 创建时间(YYYY-MM-DD HH:MM:SS)
    */
    @Excel(name = "创建时间(YYYY-MM-DD HH:MM:SS)")
    private String creator;
    /**
    * 创建人
    */
    @Excel(name = "创建人")
    private Date createDate;
    /**
    * 更新时间(YYYY-MM-DD HH:MM:SS)
    */
    @Excel(name = "更新时间(YYYY-MM-DD HH:MM:SS)")
    private String updater;
    /**
    * 更新人
    */
    @Excel(name = "更新人")
    private Date updateDate;
}