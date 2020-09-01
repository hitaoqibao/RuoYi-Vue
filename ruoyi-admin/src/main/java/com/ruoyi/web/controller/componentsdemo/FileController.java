package com.ruoyi.web.controller.componentsdemo;

import java.io.IOException;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.system.service.FileService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "文件相关")
@RestController
@RequestMapping(value = "/testfile")
public class FileController {

    @Autowired
    FileService fileService;

    @PreAuthorize("@ss.hasPermi('components-demo:avatar-upload:list')")
    @ApiOperation(value = "action方式上传文件")
    @RequestMapping(value = "/actionupload", method = RequestMethod.POST)
    public AjaxResult actionupload(@RequestParam("file") MultipartFile file) throws IOException {
        AjaxResult ajaxResult = fileService.uploadFile(file);
        return ajaxResult;
    }
}