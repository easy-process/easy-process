package com.easyprocess.core.org.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;

import com.easyprocess.core.org.Role;
import com.easyprocess.core.org.RoleService;
import com.easyprocess.core.org.User;

@Service
public class RoleServiceImpl implements RoleService {

  @Override
  public List<User> findByRoleId(String roleId) {
    return null;
  }

  @Override
  public boolean employeeInRoles(User user, Collection<Role> roles) {
    // TODO: 判断
    return false;
  }
}
