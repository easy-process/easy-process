package com.easyprocess.core.content.process;

import java.util.Optional;

import com.easyprocess.core.content.process.node.Node;

public interface ProcessContent {

  /**
   * 获取开始的节点
   *
   * @return 开始节点
   */
  Node getStartNode();

  /**
   * 根据节点id, 查找节点
   *
   * @param nodeId 节点id
   * @return 查到的节点
   */
  Optional<Node> find(String nodeId);

}
