package com.easyprocess.core.org;

import java.util.List;

public interface OrgService {

  List<User> findLeaderWithLevel(String deptId, int level);

}
