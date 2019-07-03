package com.uniedp.modules.test.controller;    /**
 * Copyright &copy; 2013-2019 山东易科德软件有限公司
 * All rights reserved.
 */

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
import com.uniedp.modules.test.dto.TestTableDevDTO;
import com.uniedp.modules.test.service.TestTableDevService;
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
 * test_table_dev(测试单表开发)
 * 测试单表开发Controller
 *
 * @author xds
 * @since 2019-05-30
 */
@RestController
@RequestMapping("test/testTableDev")
@Api(tags = "测试单表开发")
public class TestTableDevController {
    @Autowired
    private TestTableDevService testTableDevService;

    @GetMapping("page")
    @ApiOperation("分页")
    @ApiImplicitParams({
            @ApiImplicitParam(name = Constant.PAGE, value = "当前页码，从1开始", paramType = "query", required = true, dataType = "int"),
            @ApiImplicitParam(name = Constant.LIMIT, value = "每页显示记录数", paramType = "query", required = true, dataType = "int"),
            @ApiImplicitParam(name = Constant.ORDER_FIELD, value = "排序字段", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = Constant.ORDER, value = "排序方式，可选值(asc、desc)", paramType = "query", dataType = "String")
    })
    @RequiresPermissions("test:testTableDev:page")
    public Result<PageData<TestTableDevDTO>> page(@ApiIgnore @RequestParam Map<String, Object> params) {
        PageData<TestTableDevDTO> page = testTableDevService.page(params);

        return new Result<PageData<TestTableDevDTO>>().ok(page);
    }

    @GetMapping("{id}")
    @ApiOperation("信息")
    @RequiresPermissions("test:testTableDev:info")
    public Result<TestTableDevDTO> get(@PathVariable("id") Long id) {
        TestTableDevDTO data = testTableDevService.get(id);

        return new Result<TestTableDevDTO>().ok(data);
    }

    @PostMapping
    @ApiOperation("保存")
    @LogOperation("保存")
    @RequiresPermissions("test:testTableDev:save")
    public Result save(@RequestBody TestTableDevDTO dto) {
        //效验数据
        ValidatorUtils.validateEntity(dto, AddGroup.class, DefaultGroup.class);

        testTableDevService.save(dto);

        return new Result().ok(dto);
    }

    @PutMapping
    @ApiOperation("修改")
    @LogOperation("修改")
    @RequiresPermissions("test:testTableDev:update")
    public Result update(@RequestBody TestTableDevDTO dto) {
        //效验数据
        ValidatorUtils.validateEntity(dto, UpdateGroup.class, DefaultGroup.class);

        testTableDevService.update(dto);

        return new Result().ok(dto);
    }

    @DeleteMapping
    @ApiOperation("删除")
    @LogOperation("删除")
    @RequiresPermissions("test:testTableDev:delete")
    public Result delete(@RequestBody Long[] ids) {
        //效验数据
        AssertUtils.isArrayEmpty(ids, "id");

        testTableDevService.delete(ids);

        return new Result();
    }

    @GetMapping("export")
    @ApiOperation("导出")
    @LogOperation("导出")
    @RequiresPermissions("test:testTableDev:export")
    public void export(@ApiIgnore @RequestParam Map<String, Object> params, HttpServletResponse response) throws Exception {
        List<TestTableDevDTO> list = testTableDevService.list(params);

        ExcelUtils.exportExcelToTarget(response, null, list, com.uniedp.test.execl.TestTableDevExcel.class);
    }

}