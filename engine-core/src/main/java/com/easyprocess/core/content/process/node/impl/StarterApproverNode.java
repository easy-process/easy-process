package com.easyprocess.core.content.process.node.impl;

import java.util.Collections;
import java.util.List;

import com.easyprocess.core.engine.Context;
import com.easyprocess.core.org.User;

public class StarterApproverNode extends AbstractApproverNode {

  @Override
  public List<User> getApprovers() {
    return Collections.singletonList(Context.getContext().getStarter());
  }

}
