package com.easyprocess.core.org;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Department {

  private String deptId;
  private String deptName;
}
