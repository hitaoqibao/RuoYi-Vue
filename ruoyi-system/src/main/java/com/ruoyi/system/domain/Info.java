package com.ruoyi.system.domain;

import com.ruoyi.common.annotation.Excel;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 信息表
 * </p>
 *
 * @author baochengkang
 * @since 2020-08-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Info implements Serializable {

  private static final long serialVersionUID = 1L;

  /**
   * 序号
   */
  @Excel(name = "序号")
  private Integer id;

  /**
   * 作品
   */
  @Excel(name = "作品")
  private String title;

  /**
   * 作者
   */
  @Excel(name = "作者")
  private String author;

  /**
   * 阅读数
   */
  @Excel(name = "阅读数")
  private Integer readings;

  /**
   * 时间
   */
  @Excel(name = "时间")
  private String date;

}
