package com.easyprocess.core.content.process.node.impl;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import lombok.Setter;
import org.apache.commons.collections4.MapUtils;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.easyprocess.core.content.process.node.NoticeNode;
import com.easyprocess.core.content.process.notice.NoticeDefinition;
import com.easyprocess.core.content.process.notice.NoticeType;
import com.easyprocess.core.exceptions.ApproverParseException;
import com.easyprocess.core.org.User;

public class NoticeNodeImpl extends AbstractNode implements NoticeNode {

  @Setter
  private List<NoticeDefinition> noticeDefinitions;

  @Override
  public List<User> getNotifiers() {
    return this.noticeDefinitions.stream()
        .map(this::parseNoticeDefinition)
        .flatMap(Collection::stream)
        .collect(Collectors.toList());
  }

  private List<User> parseNoticeDefinition(NoticeDefinition noticeDefinition) {
    NoticeType noticeType = noticeDefinition.getNoticeType();
    JSONObject config = noticeDefinition.getConfig();

    NoticeNode node;

    if (noticeType == NoticeType.LEADER) {
      node = new LeaderApproverNode(MapUtils.getInteger(config, "leaderLevel", 1));
    } else if (noticeType == NoticeType.ROLE) {
      node = new RoleApproverNode(config.getString("roleId"), config.getString("roleName"));
    } else if (noticeType == NoticeType.USER) {
      String users = config.getString("users");
      node = new UserApproverNode(JSON.parseArray(users, User.class));
    } else if (noticeType == NoticeType.FORM_CONTACT) {
      node = new FormContactApproverNode(config.getString("formContactItemId"));
    } else {
      throw new ApproverParseException(String.format("不支持的抄送人类型节点: %s", noticeType));
    }

    return node.getNotifiers();
  }

}
