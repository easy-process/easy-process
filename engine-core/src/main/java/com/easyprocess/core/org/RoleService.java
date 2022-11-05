package com.easyprocess.core.org;

import java.util.List;

public interface RoleService {

  List<User> findByRoleId(String roleId);
}
