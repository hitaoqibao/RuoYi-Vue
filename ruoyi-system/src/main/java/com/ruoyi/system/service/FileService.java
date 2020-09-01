package com.ruoyi.system.service;

import java.io.IOException;

import com.ruoyi.common.core.domain.AjaxResult;

import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 * 文件操作 服务类
 * </p>
 *
 * @author baochengkang
 * @since 2020-07-13
 */
public interface FileService {

  AjaxResult uploadFile(MultipartFile file) throws IOException;
}