package com.easyprocess.core.content.process.node.impl;

import java.util.List;

import com.easyprocess.core.content.process.node.NoticeNode;
import com.easyprocess.core.engine.Context;
import com.easyprocess.core.org.OrgService;
import com.easyprocess.core.org.User;

/**
 * 主管审批
 */
public class LeaderApproverNode extends AbstractApproverNode implements NoticeNode {

  private final int leaderLevel;

  public LeaderApproverNode(int leaderLevel) {
    this.leaderLevel = leaderLevel;
    this.title = String.format("%s级主管", leaderLevel);
  }

  @Override
  public List<User> getApprovers() {
    OrgService orgService = Context.getOrgService();
    String starterDeptId = Context.getContext().getStarterDeptId();
    return orgService.findLeaderWithLevel(starterDeptId, leaderLevel);
  }

  @Override
  public List<User> getNotifiers() {
    return this.getApprovers();
  }
}
