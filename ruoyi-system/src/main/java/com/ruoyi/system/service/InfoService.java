package com.ruoyi.system.service;

import java.util.List;

import com.ruoyi.system.domain.Info;

/**
 * 信息表 服务层
 * 
 * @author baochengkang
 */
public interface InfoService {

  /**
   * 查询信息表所有数据
   * 
   * @return 数据表数据
   */
  public List<Info> allinfo();

  /**
   * 导入数据
   * 
   * @param list            数据列表
   * @param isUpdateSupport 是否更新支持，如果已存在，则进行更新数据
   * @param operName        操作用户
   * @return 结果
   */
  public String importList(List<Info> list, Boolean isUpdateSupport, String operName);
}