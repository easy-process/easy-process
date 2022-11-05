package com.easyprocess.core.content.process.node.impl;

import com.easyprocess.core.content.process.node.ApproverNode;
import com.easyprocess.core.enums.ApprovalType;

public abstract class AbstractApproverNode extends AbstractNode implements ApproverNode {

  private ApprovalType approvalType;

  @Override
  public ApprovalType getApprovalType() {
    return this.approvalType == null ? ApprovalType.SELECT_ONE : this.approvalType;
  }

  public void setApprovalType(ApprovalType approvalType) {
    this.approvalType = approvalType;
  }
}
