/**
 * Copyright &copy; 2013-2019 山东易科德软件有限公司
 * All rights reserved.
 */
package com.uniedp.modules.test.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;


import java.util.Date;

/**
 * test_table_tree(测试树表开发)
 * 测试树表操作Excel
 * @author songchen
 * @since  2019-06-18
 */
@Data
public class TestTableTreeExcel {
	private static final long serialVersionUID = 1L;
    /**
    * id
    */
    @Excel(name = "id")
    private Long id;
    /**
    * 代码
    */
    @Excel(name = "代码")
    private String code;
    /**
    * 名称
    */
    @Excel(name = "名称")
    private String name;
    /**
    * 父级编码
    */
    @Excel(name = "父级编码")
    private Long pid;
    /**
    * 所有父级编码
    */
    @Excel(name = "所有父级编码")
    private String pids;
    /**
    * 图标
    */
    @Excel(name = "图标")
    private String icon;
    /**
    * 级别
    */
    @Excel(name = "级别")
    private Integer treeLevel;
    /**
    * 备注
    */
    @Excel(name = "备注")
    private String remarks;
    /**
    * 排序
    */
    @Excel(name = "排序")
    private Integer sort;
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