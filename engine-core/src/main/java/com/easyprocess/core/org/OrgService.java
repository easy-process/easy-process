package com.easyprocess.core.org;

import java.util.Collection;
import java.util.List;

public interface OrgService {

  List<User> findLeaderWithLevel(String deptId, int level);

  boolean employeeInDepartmentIds(User user, Collection<Department> departments);

}
