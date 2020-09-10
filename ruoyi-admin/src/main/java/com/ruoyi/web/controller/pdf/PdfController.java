package com.ruoyi.web.controller.pdf;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.web.controller.componentsdemo.util.NonStaticResourceHttpRequestHandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ClassUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "pdf相关")
@RestController
@RequestMapping(value = "/pdf")
public class PdfController {

  @Autowired
  private NonStaticResourceHttpRequestHandler nonStaticResourceHttpRequestHandler;

  @ApiOperation(value = "pdf预览")
  @RequestMapping(value = "/openpdf", method = RequestMethod.GET)
  public void openpdf(HttpServletRequest request, HttpServletResponse response, @RequestParam("value") String value)
      throws ServletException, IOException {
    String sourcePath = ClassUtils.getDefaultClassLoader().getResource("").getPath().substring(1);
    String realPath = sourcePath + "static/pdf/" + value + ".pdf";
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