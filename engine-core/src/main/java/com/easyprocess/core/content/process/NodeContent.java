package com.easyprocess.core.content.process;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import lombok.Data;
import lombok.experimental.Accessors;

import com.alibaba.fastjson2.JSONObject;
import com.easyprocess.core.content.process.approver.ApproverType;
import com.easyprocess.core.content.process.conditions.ConditionDefinition;
import com.easyprocess.core.content.process.node.Node;
import com.easyprocess.core.content.process.node.impl.AbstractApproverNode;
import com.easyprocess.core.content.process.node.impl.AbstractNode;
import com.easyprocess.core.content.process.node.impl.FormContactApproverNode;
import com.easyprocess.core.content.process.node.impl.LeaderApproverNode;
import com.easyprocess.core.content.process.node.impl.NoticeNodeImpl;
import com.easyprocess.core.content.process.node.impl.RoleApproverNode;
import com.easyprocess.core.content.process.node.impl.StarterApproverNode;
import com.easyprocess.core.content.process.node.impl.UserApproverNode;
import com.easyprocess.core.content.process.notice.NoticeDefinition;
import com.easyprocess.core.enums.ApprovalType;
import com.easyprocess.core.enums.NodeType;
import com.easyprocess.core.exceptions.ApproverParseException;
import com.easyprocess.core.org.User;

@Data
@Accessors(chain = true)
public class NodeContent {

  private String id;
  private String title;
  private NodeContent next;
  private List<NodeContent> children;
  private ConditionDefinition condition;

  private NodeType type;

  private List<NoticeDefinition> noticeDefinitions;

  //------------------ApproverNode-------------------
  // 审批人类型
  private ApproverType approverType;
  // 审批类型
  private ApprovalType approvalType;

  // 节点配置
  private JSONObject config;

  private int leaderLevel;

  private String roleId;
  private String roleName;

  private List<User> users;

  private String formContactItemId;

  //------------------ApproverNode-------------------

  //------------------ConditionNode-------------------
  // TODO: 条件节点内容细化
  //------------------ConditionNode-------------------

  public Node toNode() {
    return parseNode();
  }

  private Node parseNode() {
    if (this.type == NodeType.APPROVER) {
      return buildApproverNode();
    }

    if (this.type == NodeType.NOTICE) {
      return buildNoticeNode();
    }

    // TODO: 根据不同的type 解析成不同的节点类型
    return null;
  }

  private Node buildNoticeNode() {
    NoticeNodeImpl noticeNode = new NoticeNodeImpl();
    noticeNode.setNoticeDefinitions(this.noticeDefinitions);
    setNodeBaseInfo(noticeNode);
    return noticeNode;
  }

  private AbstractApproverNode buildApproverNode() {
    AbstractApproverNode node;
    if (this.approverType == ApproverType.LEADER) {
      node = new LeaderApproverNode(this.leaderLevel);
    } else if (this.approverType == ApproverType.ROLE) {
      node = new RoleApproverNode(this.roleId, this.roleName);
    } else if (this.approverType == ApproverType.USER) {
      node = new UserApproverNode(this.users);
    } else if (this.approverType == ApproverType.FORM_CONTACT) {
      node = new FormContactApproverNode(this.formContactItemId);
    } else if (this.approverType == ApproverType.STARTER) {
      node = new StarterApproverNode();
    } else {
      throw new ApproverParseException(String.format("不支持的审批人类型节点: %s", this.approverType));
    }

    node.setApprovalType(this.approvalType);
    setNodeBaseInfo(node);
    return node;
  }

  private void setNodeBaseInfo(AbstractNode node) {
    node.setId(this.id);
    node.setTitle(this.title);
    node.setChildren(Optional.ofNullable(children)
        .map(list -> list.stream().map(NodeContent::toNode).collect(Collectors.toList()))
        .orElse(Collections.emptyList()));
    node.setNext(Optional.ofNullable(this.next).map(NodeContent::toNode).orElse(null));
  }

}
