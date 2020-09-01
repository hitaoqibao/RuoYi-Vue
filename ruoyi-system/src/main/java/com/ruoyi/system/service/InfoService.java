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
}