package com.easyprocess.core.content.process.node.impl;

import java.util.List;

import com.easyprocess.core.content.process.node.NoticeNode;
import com.easyprocess.core.engine.Context;
import com.easyprocess.core.org.User;

public class FormContactApproverNode extends AbstractApproverNode implements NoticeNode {

  private final String formContactItemId;

  public FormContactApproverNode(String formContactItemId) {
    this.formContactItemId = formContactItemId;
  }

  @Override
  public List<User> getApprovers() {
    return Context.getContext().getFormInstance().getFormContact(this.formContactItemId);
  }

  @Override
  public List<User> getNotifiers() {
    return this.getApprovers();
  }

}
