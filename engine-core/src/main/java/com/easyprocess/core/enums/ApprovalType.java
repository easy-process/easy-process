package com.easyprocess.core.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ApprovalType {
  SELECT_ONE("任选一个"),
  OR("或签"),
  AND("会签"),
  ONE_BY_ONE("依次审批"),
  ;
  private final String desc;
}
