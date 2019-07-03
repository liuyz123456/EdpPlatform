/**
 * Copyright &copy; 2013-2019 山东易科德软件有限公司
 * All rights reserved.
 */
package com.uniedp.modules.test.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

import java.util.Date;

/**
 * test_table_tree(测试树表开发)
 * 测试树表操作DTO
 * @author songchen
 * @since  2019-06-18
 */
@Data
@ApiModel(value = "测试树表开发")
public class TestTableTreeDTO implements Serializable {
	private static final long serialVersionUID = 1L;

    /**
    * id
    */
    @ApiModelProperty(value = "id")
    private Long id;
    /**
    * 代码
    */
    @ApiModelProperty(value = "代码")
    private String code;
    /**
    * 名称
    */
    @ApiModelProperty(value = "名称")
    private String name;
    /**
    * 父级编码
    */
    @ApiModelProperty(value = "父级编码")
    private Long pid;
    /**
    * 所有父级编码
    */
    @ApiModelProperty(value = "所有父级编码")
    private String pids;
    /**
    * 图标
    */
    @ApiModelProperty(value = "图标")
    private String icon;
    /**
    * 级别
    */
    @ApiModelProperty(value = "级别")
    private Integer treeLevel;
    /**
    * 备注
    */
    @ApiModelProperty(value = "备注")
    private String remarks;
    /**
    * 排序
    */
    @ApiModelProperty(value = "排序")
    private Integer sort;
    /**
    * 状态
    */
    @ApiModelProperty(value = "状态")
    private Integer status;
    /**
    * 创建时间(YYYY-MM-DD HH:MM:SS)
    */
    @ApiModelProperty(value = "创建时间(YYYY-MM-DD HH:MM:SS)")
    private String creator;
    /**
    * 创建人
    */
    @ApiModelProperty(value = "创建人")
    private Date createDate;
    /**
    * 更新时间(YYYY-MM-DD HH:MM:SS)
    */
    @ApiModelProperty(value = "更新时间(YYYY-MM-DD HH:MM:SS)")
    private String updater;
    /**
    * 更新人
    */
    @ApiModelProperty(value = "更新人")
    private Date updateDate;
}