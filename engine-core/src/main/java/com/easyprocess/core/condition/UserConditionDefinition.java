package com.easyprocess.core.condition;

import java.util.List;

import lombok.Data;
import lombok.experimental.Accessors;

import com.easyprocess.core.org.Department;
import com.easyprocess.core.org.Role;
import com.easyprocess.core.org.User;

@Data
@Accessors(chain = true)
public class UserConditionDefinition {

  private List<User> users;
  private List<Department> departments;
  private List<Role> roles;
}
