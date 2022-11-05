package com.easyprocess.core.content.process.node.impl;

import java.util.List;

import com.easyprocess.core.content.process.node.Node;

public abstract class AbstractNode implements Node {

  protected String id;
  protected String title;
  protected List<Node> children;
  protected Node next;

  @Override
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  @Override
  public String getTitle() {
    return title;
  }

  @Override
  public List<Node> getChildren() {
    return children;
  }

  @Override
  public Node getNext() {
    return next;
  }

  public void setChildren(List<Node> children) {
    this.children = children;
  }

  public void setNext(Node next) {
    this.next = next;
  }
}
