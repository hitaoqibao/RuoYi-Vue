package com.ruoyi.system.mapper;

import java.util.List;

import com.ruoyi.system.domain.Info;

/**
 * 信息表 数据层
 * 
 * @author baochengkang
 */
public interface InfoMapper {

  /**
   * 查询信息表所有数据
   * 
   * @return 数据表数据
   */
  public List<Info> selectinfo();

  // 新增信息表数据
  public int insertInfo(Info info);
}