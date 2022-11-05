package com.easyprocess.core.content.process.node;

import java.util.List;

import com.easyprocess.core.enums.ApprovalType;
import com.easyprocess.core.org.User;

public interface ApproverNode extends Node {

  List<User> getApprovers();

  ApprovalType getApprovalType();

}
