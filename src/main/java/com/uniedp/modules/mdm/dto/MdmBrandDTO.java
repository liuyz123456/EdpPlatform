package com.uniedp.modules.mdm.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * 品牌
 *
 * @author songchen 
 * @since 1.0.0 2019-02-28
 */
@Data
@ApiModel(value = "品牌")
public class MdmBrandDTO implements Serializable {
    private static final long serialVersionUID = 1L;

        @ApiModelProperty(value = "id")
    private String id;
        @ApiModelProperty(value = "品牌编码")
    private String brandCode;
        @ApiModelProperty(value = "品牌名称")
    private String brandName;
        @ApiModelProperty(value = "图片地址")
    private String imgPath;
        @ApiModelProperty(value = "是否热搜")
    private String statusHot;
        @ApiModelProperty(value = "集团编码")
    private String groupCode;
        @ApiModelProperty(value = "集团名称")
    private String groupName;
        @ApiModelProperty(value = "是否展示")
    private String isShow;
        @ApiModelProperty(value = "状态")
    private String status;
        @ApiModelProperty(value = "创建人")
    private String creator;
        @ApiModelProperty(value = "创建时间")
    private Date createDate;
        @ApiModelProperty(value = "更新人")
    private String updateBy;
        @ApiModelProperty(value = "更新时间")
    private Date updateDate;
        @ApiModelProperty(value = "备注")
    private String remarks;
    
}