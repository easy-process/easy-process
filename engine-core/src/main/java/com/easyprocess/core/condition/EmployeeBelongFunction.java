package com.easyprocess.core.condition;

import java.util.Map;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Component;

import com.easyprocess.core.org.OrgService;
import com.easyprocess.core.org.User;
import com.googlecode.aviator.runtime.function.FunctionUtils;
import com.googlecode.aviator.runtime.type.AviatorObject;

@Slf4j
@Component
public class EmployeeBelongFunction extends AbstractConditionEvaluator {

  private final OrgService orgService;

  public EmployeeBelongFunction(OrgService orgService) {
    this.orgService = orgService;
  }

  @Override
  public String getName() {
    return "employeeBelong";
  }

  @Override
  public AviatorObject call(Map<String, Object> env, AviatorObject arg1, AviatorObject arg2) {

    User user = (User) FunctionUtils.getJavaObject(arg1, env);
    UserConditionDefinition userCondition = (UserConditionDefinition) FunctionUtils.getJavaObject(arg2, env);

    if (CollectionUtils.isNotEmpty(userCondition.getDepartments())) {
      if (orgService.employeeInDepartmentIds(user, userCondition.getDepartments())) {
        return FunctionUtils.wrapReturn(true);
      }
    }

    // TODO(helios): role / users 判断
    log.info("user = {}", user);
    log.info("userCondition = {}", userCondition);
    return null;
  }
}
