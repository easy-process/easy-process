package com.easyprocess.core.org;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Role {

  private String roleId;
  private String roleName;
}
