package com.ruoyi.web.controller.componentsdemo;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.system.service.FileService;
import com.ruoyi.web.controller.componentsdemo.util.NonStaticResourceHttpRequestHandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.ClassUtils;
import org.springframework.util.StringUtils;
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
    private FileService fileService;

    @Autowired
    private NonStaticResourceHttpRequestHandler nonStaticResourceHttpRequestHandler;

    @PreAuthorize("@ss.hasPermi('components-demo:avatar-upload:list')")
    @ApiOperation(value = "action方式上传文件")
    @RequestMapping(value = "/actionupload", method = RequestMethod.POST)
    public AjaxResult actionupload(@RequestParam("file") MultipartFile file) throws IOException {
        AjaxResult ajaxResult = fileService.uploadFile(file);
        return ajaxResult;
    }

    @ApiOperation(value = "视频播放")
    @RequestMapping(value = "/video", method = RequestMethod.GET)
    public void videoPreview(HttpServletRequest request, HttpServletResponse response,
            @RequestParam("filename") String filename) throws Exception {
        // 假如我把视频1.mp4放在了static下的video文件夹里面
        // sourcePath 是获取target文件夹的绝对地址
        // realPath 即是视频所在的磁盘地址
        String sourcePath = ClassUtils.getDefaultClassLoader().getResource("").getPath().substring(1);
        String realPath = sourcePath + "static/video/" + filename + ".mp4";

        Path filePath = Paths.get(realPath);
        if (Files.exists(filePath)) {
            String mimeType = Files.probeContentType(filePath);
            if (!StringUtils.isEmpty(mimeType)) {
                response.setContentType(mimeType);
            }
            request.setAttribute(NonStaticResourceHttpRequestHandler.ATTR_FILE, filePath);
            nonStaticResourceHttpRequestHandler.handleRequest(request, response);
        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            response.setCharacterEncoding(StandardCharsets.UTF_8.toString());
        }
    }

}