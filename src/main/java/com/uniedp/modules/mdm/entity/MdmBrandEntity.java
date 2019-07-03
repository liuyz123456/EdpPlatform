package com.uniedp.modules.mdm.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.uniedp.core.entity.BaseEntity;
import com.uniedp.core.entity.UuidBaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 品牌
 *
 * @author songchen
 * @since 1.0.0 2019-02-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("mdm_brand")
public class MdmBrandEntity extends UuidBaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 品牌编码
     */
    private String brandCode;
    /**
     * 品牌名称
     */
    private String brandName;
    /**
     * 图片地址
     */
    private String imgPath;
    /**
     * 是否热搜
     */
    private String statusHot;
    /**
     * 集团编码
     */
    private String groupCode;
    /**
     * 集团名称
     */
    private String groupName;
    /**
     * 是否展示
     */
    private String isShow;
    /**
     * 状态
     */
    private String status;
    /**
     * 更新人
     */
    @TableField(fill = FieldFill.UPDATE)
    private String updateBy;
    /**
     * 更新时间
     */
    @TableField(fill = FieldFill.UPDATE)
    private Date updateDate;
    /**
     * 备注
     */
    private String remarks;
}