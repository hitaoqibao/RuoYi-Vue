package com.ruoyi.web.controller.excel;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.core.domain.AjaxResult;
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

    @PreAuthorize("@ss.hasPermi('excel:info:list')")
    @ApiOperation(value = "信息表所有信息")
    @RequestMapping(value = "/allinfo", method = RequestMethod.GET)
    public AjaxResult allinfo() {
        JSONObject jsonObject = new JSONObject();
        List<Info> list = infoService.allinfo();
        jsonObject.put("list", list);
        return AjaxResult.success(jsonObject);
    }

}