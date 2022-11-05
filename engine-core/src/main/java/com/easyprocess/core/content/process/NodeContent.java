package com.easyprocess.core.content.process;

import lombok.Data;

import com.easyprocess.core.content.process.node.Node;
import com.easyprocess.core.enums.NodeType;

@Data
public class NodeContent {

  private NodeType type;
  private String definition;

  public Node toNode() {
    // TODO: 根据不同的type 解析成不同的节点类型
    return null;
  }
}
