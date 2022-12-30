package com.easyprocess.core.content.process.node.impl;

import java.util.List;

import com.easyprocess.core.content.process.node.NoticeNode;
import com.easyprocess.core.org.User;

public class UserApproverNode extends AbstractApproverNode implements NoticeNode {

  private final List<User> users;

  public UserApproverNode(List<User> users) {
    this.users = users;
  }

  @Override
  public List<User> getApprovers() {
    return this.users;
  }

  @Override
  public List<User> getNotifiers() {
    return this.users;
  }
}
