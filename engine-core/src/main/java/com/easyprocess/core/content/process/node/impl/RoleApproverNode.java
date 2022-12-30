package com.easyprocess.core.content.process.node.impl;

import java.util.List;

import com.easyprocess.core.content.process.node.NoticeNode;
import com.easyprocess.core.engine.Context;
import com.easyprocess.core.exceptions.ApproverParseException;
import com.easyprocess.core.org.User;

public class RoleApproverNode extends AbstractApproverNode implements NoticeNode {

  private final String roleId;
  private final String roleName;

  public RoleApproverNode(String roleId, String roleName) {
    this.roleId = roleId;
    this.roleName = roleName;
  }

  @Override
  public List<User> getApprovers() {
    try {
      return Context.getRoleService().findByRoleId(roleId);
    } catch (Exception e) {
      throw new ApproverParseException(String.format("根据角色 %s[%s] 获取用户列表异常", roleName, roleId), e);
    }
  }

  @Override
  public List<User> getNotifiers() {
    return this.getApprovers();
  }
}
