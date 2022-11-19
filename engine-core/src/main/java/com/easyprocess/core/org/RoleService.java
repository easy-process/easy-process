package com.easyprocess.core.org;

import java.util.Collection;
import java.util.List;

public interface RoleService {

  List<User> findByRoleId(String roleId);

  boolean employeeInRoles(User user, Collection<Role> roles);
}
