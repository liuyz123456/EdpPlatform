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
import java.util.Map;

/**
 * test_oss(测试文件上传业务表)
 * 文件上传DTO
 *
 * @author YJ
 * @since 2019-06-24
 */
@Data
@ApiModel(value = "测试文件上传业务表")
public class TestOssDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @ApiModelProperty(value = "id")
    private Long id;
    /**
     * 测试业务名
     */
    @ApiModelProperty(value = "测试业务名")
    private String name;
    /**
     * 创建者
     */
    @ApiModelProperty(value = "创建者")
    private String creator;
    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Date createDate;
    /**
     * 更新者
     */
    @ApiModelProperty(value = "更新者")
    private String updater;
    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间")
    private Date updateDate;

    //    private Map<String, Object>[] fileList;
    private List<Map<String, Object>> fileList;
    private List<Map<String, Object>> fileList1;
    private List<Map<String, Object>> fileList2;
}