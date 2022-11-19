package com.easyprocess.core.org.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.easyprocess.core.org.Department;
import com.easyprocess.core.org.OrgService;
import com.easyprocess.core.org.User;

@Service
public class OrgServiceImpl implements OrgService {

  @Override
  public List<User> findLeaderWithLevel(String deptId, int level) {
    // TODO: 根据部门id, 主管层级 获取主管信息
    return Collections.emptyList();
  }

  @Override
  public boolean employeeInDepartmentIds(User user, Collection<Department> departments) {
    // TODO: 判断员工是否属于给定部门
    return false;
  }

}
