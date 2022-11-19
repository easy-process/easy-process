package com.easyprocess.core.condition;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import com.easyprocess.core.org.Department;
import com.easyprocess.core.org.OrgService;
import com.easyprocess.core.org.User;
import com.google.common.collect.Lists;
import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.Expression;

@Slf4j
class EmployeeBelongFunctionTest {

  @Test
  public void testEmployeeBelong() {
    ConditionEvaluatorRegistry.register(new EmployeeBelongFunction(new OrgService() {
      @Override
      public List<User> findLeaderWithLevel(String deptId, int level) {
        return null;
      }

      @Override
      public boolean employeeInDepartmentIds(User user, Collection<Department> departments) {
        log.info("user = {}, departments = {}", user, departments);
        return true;
      }

    }));

    // 编写表达式
    String expression = "employeeBelong(a, b)";
    // 表达式编译
    Expression compiledExp = AviatorEvaluator.compile(expression, true);
    Map<String, Object> env = new HashMap<>();

    env.put("a", new User().setUserId("001").setUserName("User001"));
    UserConditionDefinition userConditionDefinition = getUserConditionDefinition();
    env.put("b", userConditionDefinition);

    Object result = compiledExp.execute(env);
    Assertions.assertThat(result).isEqualTo(true);
  }

  private static UserConditionDefinition getUserConditionDefinition() {
    UserConditionDefinition userConditionDefinition = new UserConditionDefinition();
    userConditionDefinition.setUsers(Lists.newArrayList(new User().setUserId("002").setUserName("User002")));
    userConditionDefinition.setDepartments(Lists.newArrayList(new Department().setDeptId("001").setDeptName("Dept001")));
    return userConditionDefinition;
  }

}