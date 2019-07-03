/**
 * Copyright &copy; 2013-2019 山东易科德软件有限公司
 * All rights reserved.
 */
package com.uniedp.modules.test.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;


import java.util.Date;

/**
 * test_oss(测试文件上传业务表)
 * 文件上传Excel
 * @author YJ
 * @since  2019-06-24
 */
@Data
public class TestOssExcel {
	private static final long serialVersionUID = 1L;
    /**
    * id
    */
    @Excel(name = "id")
    private Long id;
    /**
    * 测试业务名
    */
    @Excel(name = "测试业务名")
    private String name;
    /**
    * 创建者
    */
    @Excel(name = "创建者")
    private String creator;
    /**
    * 创建时间
    */
    @Excel(name = "创建时间")
    private Date createDate;
    /**
    * 更新者
    */
    @Excel(name = "更新者")
    private String updater;
    /**
    * 更新时间
    */
    @Excel(name = "更新时间")
    private Date updateDate;
}