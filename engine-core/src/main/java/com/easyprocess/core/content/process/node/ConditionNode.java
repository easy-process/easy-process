package com.easyprocess.core.content.process.node;

public interface ConditionNode extends Node {

  boolean evaluate();

  boolean isDefault();
}
