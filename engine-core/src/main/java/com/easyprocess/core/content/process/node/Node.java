package com.easyprocess.core.content.process.node;

import java.util.List;

/**
 * -> current -> [children] -> next
 */
public interface Node {

  String getId();

  String getTitle();

  Node getNext();

  List<Node> getChildren();
}
