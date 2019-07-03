package com.uniedp.modules.mdm.controller;

import com.uniedp.core.annotation.LogOperation;
import com.uniedp.core.constant.Constant;
import com.uniedp.core.page.PageData;
import com.uniedp.core.utils.ExcelUtils;
import com.uniedp.core.utils.Result;
import com.uniedp.core.validator.AssertUtils;
import com.uniedp.core.validator.ValidatorUtils;
import com.uniedp.core.validator.group.AddGroup;
import com.uniedp.core.validator.group.DefaultGroup;
import com.uniedp.core.validator.group.UpdateGroup;
import com.uniedp.modules.mdm.dto.MdmBrandDTO;
import com.uniedp.modules.mdm.excel.MdmBrandExcel;
import com.uniedp.modules.mdm.service.MdmBrandService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;


/**
 * 品牌
 *
 * @author songchen 
 * @since 1.0.0 2019-02-28
 */
@RestController
@RequestMapping("mdm/mdmbrand")
@Api(tags="品牌")
public class MdmBrandController {
    @Autowired
    private MdmBrandService mdmBrandService;

    @GetMapping("page")
    @ApiOperation("分页")
    @ApiImplicitParams({
        @ApiImplicitParam(name = Constant.PAGE, value = "当前页码，从1开始", paramType = "query", required = true, dataType="int") ,
        @ApiImplicitParam(name = Constant.LIMIT, value = "每页显示记录数", paramType = "query",required = true, dataType="int") ,
        @ApiImplicitParam(name = Constant.ORDER_FIELD, value = "排序字段", paramType = "query", dataType="String") ,
        @ApiImplicitParam(name = Constant.ORDER, value = "排序方式，可选值(asc、desc)", paramType = "query", dataType="String")
    })
    @RequiresPermissions("mdm:mdmbrand:page")
    public Result<PageData<MdmBrandDTO>> page(@ApiIgnore @RequestParam Map<String, Object> params){
        PageData<MdmBrandDTO> page = mdmBrandService.page(params);

        return new Result<PageData<MdmBrandDTO>>().ok(page);
    }

    @GetMapping("{id}")
    @ApiOperation("信息")
    @RequiresPermissions("mdm:mdmbrand:info")
    public Result<MdmBrandDTO> get(@PathVariable("id") String id){
        MdmBrandDTO data = mdmBrandService.getByString(id);

        return new Result<MdmBrandDTO>().ok(data);
    }

    @PostMapping
    @ApiOperation("保存")
    @LogOperation("保存")
    @RequiresPermissions("mdm:mdmbrand:save")
    public Result save(@RequestBody MdmBrandDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, AddGroup.class, DefaultGroup.class);
        mdmBrandService.save(dto);
        return new Result();
    }

    @PutMapping
    @ApiOperation("修改")
    @LogOperation("修改")
    @RequiresPermissions("mdm:mdmbrand:update")
    public Result update(@RequestBody MdmBrandDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, UpdateGroup.class, DefaultGroup.class);

        mdmBrandService.update(dto);

        return new Result();
    }

    @DeleteMapping
    @ApiOperation("删除")
    @LogOperation("删除")
    @RequiresPermissions("mdm:mdmbrand:delete")
    public Result delete(@RequestBody Long[] ids){
        //效验数据
        AssertUtils.isArrayEmpty(ids, "id");

        mdmBrandService.delete(ids);

        return new Result();
    }

    @GetMapping("export")
    @ApiOperation("导出")
    @LogOperation("导出")
    @RequiresPermissions("mdm:mdmbrand:export")
    public void export(@ApiIgnore @RequestParam Map<String, Object> params, HttpServletResponse response) throws Exception {
        List<MdmBrandDTO> list = mdmBrandService.list(params);

        ExcelUtils.exportExcelToTarget(response, null, list, MdmBrandExcel.class);
    }

}