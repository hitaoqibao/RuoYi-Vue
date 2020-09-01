package com.ruoyi.system.service.impl;

import java.util.List;

import com.ruoyi.system.domain.Info;
import com.ruoyi.system.mapper.InfoMapper;
import com.ruoyi.system.service.InfoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 信息表 服务实现
 * 
 * @author baochengkang
 */
@Service
public class InfoServiceImpl implements InfoService {

    @Autowired
    InfoMapper infoMapper;

    /**
     * 查询信息表所有数据
     * 
     * @return 数据表数据
     */
    @Override
    public List<Info> allinfo() {
        // TODO Auto-generated method stub
        List<Info> list = infoMapper.selectinfo();
        return list;
    }

}