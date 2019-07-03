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
	import com.uniedp.modules.test.dto.TestOssDTO;
	import com.uniedp.modules.test.excel.TestOssExcel;
	import com.uniedp.modules.test.service.TestOssService;
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
	 * test_oss(测试文件上传业务表)
	 * 文件上传Controller
	 * @author YJ
	 * @since  2019-06-24
	 */
	@RestController
	@RequestMapping("test/testOss")
	@Api(tags="测试文件上传业务表")
	public class TestOssController {
		@Autowired
		private TestOssService testOssService;

		@GetMapping("page")
		@ApiOperation("分页")
		@ApiImplicitParams({
			@ApiImplicitParam(name = Constant.PAGE, value = "当前页码，从1开始", paramType = "query", required = true, dataType="int") ,
			@ApiImplicitParam(name = Constant.LIMIT, value = "每页显示记录数", paramType = "query",required = true, dataType="int") ,
			@ApiImplicitParam(name = Constant.ORDER_FIELD, value = "排序字段", paramType = "query", dataType="String") ,
			@ApiImplicitParam(name = Constant.ORDER, value = "排序方式，可选值(asc、desc)", paramType = "query", dataType="String")
		})
		@RequiresPermissions("test:testOss:page")
		public Result<PageData<TestOssDTO>> page(@ApiIgnore @RequestParam Map<String, Object> params){
			PageData<TestOssDTO> page = testOssService.page(params);

			return new Result<PageData<TestOssDTO>>().ok(page);
		}

		@GetMapping("{id}")
		@ApiOperation("信息")
		@RequiresPermissions("test:testOss:info")
		public Result<TestOssDTO> get(@PathVariable("id") Long id){
			TestOssDTO data = testOssService.get(id);

			return new Result<TestOssDTO>().ok(data);
		}

		@PostMapping
		@ApiOperation("保存")
		@LogOperation("保存")
		@RequiresPermissions("test:testOss:save")
		public Result save(@RequestBody TestOssDTO dto){
			//效验数据
			ValidatorUtils.validateEntity(dto, AddGroup.class, DefaultGroup.class);

			testOssService.save(dto);

			return new Result().ok(dto);
		}

		@PutMapping
		@ApiOperation("修改")
		@LogOperation("修改")
		@RequiresPermissions("test:testOss:update")
		public Result update(@RequestBody TestOssDTO dto){
			//效验数据
			ValidatorUtils.validateEntity(dto, UpdateGroup.class, DefaultGroup.class);

			testOssService.update(dto);

			return new Result().ok(dto);
		}

		@DeleteMapping
		@ApiOperation("删除")
		@LogOperation("删除")
		@RequiresPermissions("test:testOss:delete")
		public Result delete(@RequestBody Long[] ids){
			//效验数据
			AssertUtils.isArrayEmpty(ids, "id");

			testOssService.delete(ids);

			return new Result();
		}

		@GetMapping("export")
		@ApiOperation("导出")
		@LogOperation("导出")
		@RequiresPermissions("test:testOss:export")
		public void export(@ApiIgnore @RequestParam Map<String, Object> params, HttpServletResponse response) throws Exception {
			List<TestOssDTO> list = testOssService.list(params);

			ExcelUtils.exportExcelToTarget(response, null, list, TestOssExcel.class);
		}

	}