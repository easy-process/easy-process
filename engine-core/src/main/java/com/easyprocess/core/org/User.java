package com.easyprocess.core.org;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class User {

  private String userId;
  private String userName;
}
