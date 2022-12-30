package com.easyprocess.core.content.process.notice;

import java.util.List;

import lombok.Data;
import lombok.experimental.Accessors;

import com.alibaba.fastjson2.JSONObject;
import com.easyprocess.core.org.User;

@Data
@Accessors(chain = true)
public class NoticeDefinition {

  private NoticeType noticeType;

  private JSONObject config;

  public List<User> getUsers() {
    return config.getJSONArray("users").toJavaList(User.class);
  }
}
