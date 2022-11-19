package com.easyprocess.core.condition;

import java.util.List;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Component;

import com.easyprocess.core.org.OrgService;
import com.easyprocess.core.org.RoleService;
import com.easyprocess.core.org.User;
import com.googlecode.aviator.runtime.function.FunctionUtils;
import com.googlecode.aviator.runtime.type.AviatorObject;

@Slf4j
@Component
public class EmployeeBelongFunction extends AbstractConditionEvaluator {

  private final OrgService orgService;
  private final RoleService roleService;

  public EmployeeBelongFunction(OrgService orgService, RoleService roleService) {
    this.orgService = orgService;
    this.roleService = roleService;
  }

  @Override
  public String getName() {
    return "employeeBelong";
  }

  @Override
  public AviatorObject call(Map<String, Object> env, AviatorObject arg1, AviatorObject arg2) {

    User user = (User) FunctionUtils.getJavaObject(arg1, env);
    UserConditionDefinition userCondition = (UserConditionDefinition) FunctionUtils.getJavaObject(arg2, env);

    List<User> users = userCondition.getUsers();
    if (CollectionUtils.isNotEmpty(users)) {
      if (users.stream().anyMatch(user::equals)) {
        return FunctionUtils.wrapReturn(true);
      }
    }

    if (CollectionUtils.isNotEmpty(userCondition.getRoles())) {
      return FunctionUtils.wrapReturn(roleService.employeeInRoles(user, userCondition.getRoles()));
    }

    if (CollectionUtils.isNotEmpty(userCondition.getDepartments())) {
      if (orgService.employeeInDepartmentIds(user, userCondition.getDepartments())) {
        return FunctionUtils.wrapReturn(true);
      }
    }

    return FunctionUtils.wrapReturn(false);
  }
}
