package com.easyprocess.core.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum NodeType {

  APPROVER("审批节点"),
  CONDITION("条件节点"),
  NOTICE("抄送节点"),
  ;

  private final String desc;

}
