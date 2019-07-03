/**
 * Copyright &copy; 2013-2019 山东易科德软件有限公司
 * All rights reserved.
 */
package com.uniedp.modules.test.controller;

import com.uniedp.core.annotation.LogOperation;
import com.uniedp.core.constant.Constant;
import com.uniedp.core.page.PageData;
import com.uniedp.core.utils.Result;
import com.uniedp.core.validator.AssertUtils;
import com.uniedp.core.validator.ValidatorUtils;
import com.uniedp.core.validator.group.AddGroup;
import com.uniedp.core.validator.group.DefaultGroup;
import com.uniedp.core.validator.group.UpdateGroup;
import com.uniedp.modules.test.dto.TestTableDevChildDTO;
import com.uniedp.modules.test.service.TestTableDevChildService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;
import java.util.Map;

/**
 * test_table_dev_child(测试单表开发)
 * 测试单表操作Controller
 *
 * @author songchen
 * @since 2019-06-20
 */
@RestController
@RequestMapping("test/testTableDevChild")
@Api(tags = "测试单表开发")
public class TestTableDevChildController {
    @Autowired
    private TestTableDevChildService testTableDevChildService;

    @GetMapping("page")
    @ApiOperation("分页")
    @ApiImplicitParams({
            @ApiImplicitParam(name = Constant.PAGE, value = "当前页码，从1开始", paramType = "query", required = true, dataType = "int"),
            @ApiImplicitParam(name = Constant.LIMIT, value = "每页显示记录数", paramType = "query", required = true, dataType = "int"),
            @ApiImplicitParam(name = Constant.ORDER_FIELD, value = "排序字段", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = Constant.ORDER, value = "排序方式，可选值(asc、desc)", paramType = "query", dataType = "String")
    })
    public Result<PageData<TestTableDevChildDTO>> page(@ApiIgnore @RequestParam Map<String, Object> params) {
        PageData<TestTableDevChildDTO> page = testTableDevChildService.page(params);
        return new Result<PageData<TestTableDevChildDTO>>().ok(page);
    }

    @GetMapping("{id}")
    @ApiOperation("信息")
    public Result<TestTableDevChildDTO> get(@PathVariable("id") Long id) {
        TestTableDevChildDTO data = testTableDevChildService.get(id);
        return new Result<TestTableDevChildDTO>().ok(data);
    }

    @GetMapping("list")
    @ApiOperation("列表")
    public Result<List<TestTableDevChildDTO>> list(@ApiIgnore @RequestParam Map<String, Object> params) {
        List<TestTableDevChildDTO> list = testTableDevChildService.list(params);
        return new Result<List<TestTableDevChildDTO>>().ok(list);
    }

    @PostMapping
    @ApiOperation("保存")
    @LogOperation("保存")
    public Result save(@RequestBody TestTableDevChildDTO dto) {
        //效验数据
        ValidatorUtils.validateEntity(dto, AddGroup.class, DefaultGroup.class);
        testTableDevChildService.save(dto);
        return new Result().ok(dto);
    }

    @PutMapping
    @ApiOperation("修改")
    @LogOperation("修改")
    public Result update(@RequestBody TestTableDevChildDTO dto) {
        //效验数据
        ValidatorUtils.validateEntity(dto, UpdateGroup.class, DefaultGroup.class);
        testTableDevChildService.update(dto);
        return new Result().ok(dto);
    }

    @DeleteMapping
    @ApiOperation("删除")
    @LogOperation("删除")
    public Result delete(@RequestBody Long[] ids) {
        //效验数据
        AssertUtils.isArrayEmpty(ids, "id");
        testTableDevChildService.delete(ids);
        return new Result();
    }

}