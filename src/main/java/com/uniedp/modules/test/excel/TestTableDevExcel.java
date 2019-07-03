/**
 * Copyright &copy; 2013-2019 山东易科德软件有限公司
 * All rights reserved.
 */
package com.uniedp.test.execl;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;


import java.util.Date;

/**
 * test_table_dev(测试单表开发)
 * 测试单表开发Execl
 * @author xds
 * @since  2019-05-30
 */
@Data
public class TestTableDevExcel {
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
    * 排序
    */
    @Excel(name = "排序")
    private Long sort;
    /**
    * 状态
    */
    @Excel(name = "状态")
    private Integer status;
    /**
    * 创建时间(YYYY-MM-DD HH:MM:SS)
    */
    @Excel(name = "创建时间(YYYY-MM-DD HH:MM:SS)")
    private Date creator;
    /**
    * 创建人
    */
    @Excel(name = "创建人")
    private String createBy;
    /**
    * 更新时间(YYYY-MM-DD HH:MM:SS)
    */
    @Excel(name = "更新时间(YYYY-MM-DD HH:MM:SS)")
    private Date updater;
    /**
    * 更新人
    */
    @Excel(name = "更新人")
    private String updateBy;
    /**
    * 备注
    */
    @Excel(name = "备注")
    private String remark;
}