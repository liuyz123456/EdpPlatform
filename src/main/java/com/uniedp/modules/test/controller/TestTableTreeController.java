/**
 * Copyright &copy; 2013-2019 山东易科德软件有限公司
 * All rights reserved.
 */
package com.uniedp.modules.test.controller;

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
import com.uniedp.modules.test.dto.TestTableTreeDTO;
import com.uniedp.modules.test.excel.TestTableTreeExcel;
import com.uniedp.modules.test.service.TestTableTreeService;
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
 * test_table_tree(测试树表开发)
 * 测试树表开发Controller
 * @author songchen
 * @since 2019-06-18
 */
@RestController
@RequestMapping("test/testTableTree")
@Api(tags = "测试树表开发")
public class TestTableTreeController {
    @Autowired
    private TestTableTreeService testTableTreeService;

    @GetMapping("page")
    @ApiOperation("分页")
    @ApiImplicitParams({
            @ApiImplicitParam(name = Constant.PAGE, value = "当前页码，从1开始", paramType = "query", required = true, dataType = "int"),
            @ApiImplicitParam(name = Constant.LIMIT, value = "每页显示记录数", paramType = "query", required = true, dataType = "int"),
            @ApiImplicitParam(name = Constant.ORDER_FIELD, value = "排序字段", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = Constant.ORDER, value = "排序方式，可选值(asc、desc)", paramType = "query", dataType = "String")
    })
    @RequiresPermissions("test:testTableTree:page")
    public Result<PageData<TestTableTreeDTO>> page(@ApiIgnore @RequestParam Map<String, Object> params) {
        PageData<TestTableTreeDTO> page = testTableTreeService.page(params);
        return new Result<PageData<TestTableTreeDTO>>().ok(page);
    }

    @GetMapping("{id}")
    @ApiOperation("信息")
    @RequiresPermissions("test:testTableTree:info")
    public Result<TestTableTreeDTO> get(@PathVariable("id") Long id) {
        TestTableTreeDTO data = testTableTreeService.get(id);
        return new Result<TestTableTreeDTO>().ok(data);
    }

    @GetMapping("list")
    @ApiOperation("列表")
    @RequiresPermissions("test:testTableTree:info")
    public Result<List<TestTableTreeDTO>> list(@ApiIgnore @RequestParam Map<String, Object> params) {
        List<TestTableTreeDTO> list = testTableTreeService.list(params);
        return new Result<List<TestTableTreeDTO>>().ok(list);
    }

    @PostMapping
    @ApiOperation("保存")
    @LogOperation("保存")
    @RequiresPermissions("test:testTableTree:save")
    public Result save(@RequestBody TestTableTreeDTO dto) {
        //效验数据
        ValidatorUtils.validateEntity(dto, AddGroup.class, DefaultGroup.class);
        testTableTreeService.save(dto);
        return new Result().ok(dto);
    }

    @PutMapping
    @ApiOperation("修改")
    @LogOperation("修改")
    @RequiresPermissions("test:testTableTree:update")
    public Result update(@RequestBody TestTableTreeDTO dto) {
        //效验数据
        ValidatorUtils.validateEntity(dto, UpdateGroup.class, DefaultGroup.class);
        testTableTreeService.update(dto);
        return new Result().ok(dto);
    }

    @DeleteMapping
    @ApiOperation("删除")
    @LogOperation("删除")
    @RequiresPermissions("test:testTableTree:delete")
    public Result delete(@RequestBody Long[] ids) {
        //效验数据
        AssertUtils.isArrayEmpty(ids, "id");
        testTableTreeService.delete(ids);
        return new Result();
    }

    @GetMapping("export")
    @ApiOperation("导出")
    @LogOperation("导出")
    @RequiresPermissions("test:testTableTree:export")
    public void export(@ApiIgnore @RequestParam Map<String, Object> params, HttpServletResponse response) throws Exception {
        List<TestTableTreeDTO> list = testTableTreeService.list(params);
        ExcelUtils.exportExcelToTarget(response, null, list, TestTableTreeExcel.class);
    }

}