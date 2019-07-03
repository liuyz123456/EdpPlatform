package com.uniedp.modules.mdm.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import java.util.Date;

/**
 * 品牌
 *
 * @author songchen 
 * @since 1.0.0 2019-02-28
 */
@Data
public class MdmBrandExcel {
    @Excel(name = "id")
    private String id;
    @Excel(name = "品牌编码")
    private String brandCode;
    @Excel(name = "品牌名称")
    private String brandName;
    @Excel(name = "图片地址")
    private String imgPath;
    @Excel(name = "是否热搜")
    private String statusHot;
    @Excel(name = "集团编码")
    private String groupCode;
    @Excel(name = "集团名称")
    private String groupName;
    @Excel(name = "是否展示")
    private String isShow;
    @Excel(name = "状态")
    private String status;
    @Excel(name = "创建人")
    private String creator;
    @Excel(name = "创建时间")
    private Date createDate;
    @Excel(name = "更新人")
    private String updateBy;
    @Excel(name = "更新时间")
    private Date updateDate;
    @Excel(name = "备注")
    private String remarks;

}