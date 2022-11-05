package com.easyprocess.core.content.process.node;

import java.util.List;

import com.easyprocess.core.org.User;

public interface NoticeNode extends Node {

  List<User> getNotifiers();
}
