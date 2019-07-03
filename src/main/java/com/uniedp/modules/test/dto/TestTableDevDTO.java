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
import java.util.List;

/**
 * test_table_dev(测试单表开发)
 * 父表管理功能DTO
 * @author sss
 * @since  2019-06-20
 */
@Data
@ApiModel(value = "测试单表开发")
public class TestTableDevDTO implements Serializable {
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
    * 年龄
    */
    @ApiModelProperty(value = "年龄")
    private Long age;
    /**
    * 邮箱
    */
    @ApiModelProperty(value = "邮箱")
    private String email;
    /**
    * 生日
    */
    @ApiModelProperty(value = "生日")
    private Date brithday;
    /**
    * 手机号
    */
    @ApiModelProperty(value = "手机号")
    private String mobile;
    /**
    * 电话号码
    */
    @ApiModelProperty(value = "电话号码")
    private String phone;
    /**
    * 个人主页
    */
    @ApiModelProperty(value = "个人主页")
    private String url;
    /**
    * 排序
    */
    @ApiModelProperty(value = "排序")
    private Long sort;
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
	/**
     * 子表信息集合
     */
    @ApiModelProperty(value = "子表信息集合")
    private List<TestTableDevChildDTO> children;

    /**
     * 删除子表信息集合
     */
    @ApiModelProperty(value = "删除子表信息集合")
    private List<TestTableDevChildDTO> deltList;
}