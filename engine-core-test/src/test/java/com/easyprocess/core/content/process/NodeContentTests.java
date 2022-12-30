package com.easyprocess.core.content.process;

import java.util.ArrayList;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.easyprocess.core.content.process.node.Node;
import com.easyprocess.core.content.process.notice.NoticeDefinition;
import com.easyprocess.core.content.process.notice.NoticeType;
import com.easyprocess.core.enums.NodeType;
import com.easyprocess.core.org.User;
import com.google.common.collect.Lists;

@Slf4j
public class NodeContentTests {

  @Test
  public void testParseNode() {

    NoticeDefinition noticeDefinition = createUserNoticeDefinition();
    ArrayList<NoticeDefinition> noticeDefinitions = Lists.newArrayList(noticeDefinition);
    NodeContent noticeNode = new NodeContent()
        .setId("test_001")
        .setTitle("节点001")
        .setType(NodeType.NOTICE)
        .setNoticeDefinitions(noticeDefinitions);

    Node node = noticeNode.toNode();
    log.info("{}", JSON.toJSONString(node));
  }

  private static NoticeDefinition createUserNoticeDefinition() {
    JSONObject config = new JSONObject();
    config.put("users", JSON.parse(JSON.toJSONString(Lists.newArrayList(
        new User().setUserId("user001").setUserName("用户001"),
        new User().setUserId("user002").setUserName("用户002")
    ))));
    return new NoticeDefinition()
        .setConfig(config)
        .setNoticeType(NoticeType.USER);
  }
}
