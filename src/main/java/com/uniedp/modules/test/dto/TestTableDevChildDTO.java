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
 * test_table_dev_child(测试单表开发)
 * 测试子表DTO
 *
 * @author songchen
 * @since 2019-06-20
 */
@Data
@ApiModel(value = "测试单表开发")
public class TestTableDevChildDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @ApiModelProperty(value = "id")
    private Long id;
    /**
     * 父级id
     */
    @ApiModelProperty(value = "父级id")
    private Long parentId;
    /**
     * 父级编码
     */
    @ApiModelProperty(value = "父级编码")
    private String parentCode;
    /**
     * 代码
     */
    @ApiModelProperty(value = "代码")
    private String childCode;
    /**
     * 名称
     */
    @ApiModelProperty(value = "名称")
    private String childName;
    /**
     * 生日
     */
    @ApiModelProperty(value = "生日")
    private Date brithday;
    /**
     * 测试下拉
     */
    @ApiModelProperty(value = "测试下拉")
    private String dictTest;
    /**
     * 排序
     */
    @ApiModelProperty(value = "排序")
    private Integer sort;
    /**
     * 测试
     */
    @ApiModelProperty(value = "测试")
    private Boolean flag;
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