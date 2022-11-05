package com.easyprocess.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ProcessStatus {
  INIT("初始化"),
  ACTIVE("运行中"),
  DISABLE("禁用");

  private final String desc;

}
