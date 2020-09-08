package com.ruoyi.web.controller.excel;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.utils.ServletUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.service.TokenService;
import com.ruoyi.system.domain.Info;
import com.ruoyi.system.service.InfoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;

/**
 * <p>
 * 信息表 前端控制器
 * </p>
 *
 * @author baochengkang
 * @since 2020-08-10
 */
@Api(tags = "信息表相关")
@RestController
@RequestMapping(value = "/info")
public class InfoController {

  @Autowired
  InfoService infoService;

  @Autowired
  private TokenService tokenService;

  @PreAuthorize("@ss.hasPermi('excel:info:list')")
  @ApiOperation(value = "信息表所有信息")
  @RequestMapping(value = "/allinfo", method = RequestMethod.GET)
  public AjaxResult allinfo() {
    JSONObject jsonObject = new JSONObject();
    List<Info> list = infoService.allinfo();
    jsonObject.put("list", list);
    return AjaxResult.success(jsonObject);
  }

  @PreAuthorize("@ss.hasPermi('excel:end-export-excel:list')")
  @ApiOperation(value = "后端导出Excel")
  @GetMapping("/export")
  public AjaxResult export(String filename) {
    if (filename == "") {
      filename = "excel-list";
    }
    List<Info> list = infoService.allinfo();
    ExcelUtil<Info> util = new ExcelUtil<Info>(Info.class);
    return util.exportExcel(list, filename);
  }

  @ApiOperation(value = "获取Excel模板")
  @GetMapping("/importTemplate")
  public AjaxResult importTemplate() {
    ExcelUtil<Info> util = new ExcelUtil<Info>(Info.class);
    return util.importTemplateExcel("信息表数据");
  }

  @ApiOperation(value = "导入Excel数据")
  @PreAuthorize("@ss.hasPermi('excel:end-upload-excel:list')")
  @PostMapping("/importData")
  public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception {
    ExcelUtil<Info> util = new ExcelUtil<Info>(Info.class);
    List<Info> list = util.importExcel(file.getInputStream());
    LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
    String operName = loginUser.getUsername();
    String message = infoService.importList(list, updateSupport, operName);
    return AjaxResult.success(message);
  }
}