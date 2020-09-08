package com.ruoyi.system.service.impl;

import java.util.List;

import com.ruoyi.common.exception.CustomException;
import com.ruoyi.common.utils.StringUtils;
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

  /**
   * 导入数据
   * 
   * @param list            用户数据列表
   * @param isUpdateSupport 是否更新支持，如果已存在，则进行更新数据
   * @param operName        操作用户
   * @return 结果
   */
  @Override
  public String importList(List<Info> list, Boolean isUpdateSupport, String operName) {
    // TODO Auto-generated method stub
    if (StringUtils.isNull(list) || list.size() == 0) {
      throw new CustomException("导入数据不能为空！");
    }
    int successNum = 0;
    int failureNum = 0;
    StringBuilder successMsg = new StringBuilder();
    StringBuilder failureMsg = new StringBuilder();
    for (Info info : list) {
      try {
        infoMapper.insertInfo(info);
        successNum++;
        successMsg.append("<br/>" + successNum + "、作者 " + info.getAuthor() + " 导入成功");
      } catch (Exception e) {
        failureNum++;
        String msg = "<br/>" + failureNum + "、作者 " + info.getAuthor() + " 导入失败：";
        failureMsg.append(msg + e.getMessage());
      }
    }
    if (failureNum > 0) {
      failureMsg.insert(0, "很抱歉，导入失败！共 " + failureNum + " 条数据格式不正确，错误如下：");
      throw new CustomException(failureMsg.toString());
    } else {
      successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
    }
    return successMsg.toString();
  }

}