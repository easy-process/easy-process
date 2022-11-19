package com.easyprocess.core.condition;

import java.util.HashMap;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.easyprocess.core.org.Department;
import com.easyprocess.core.org.OrgService;
import com.easyprocess.core.org.Role;
import com.easyprocess.core.org.RoleService;
import com.easyprocess.core.org.User;
import com.google.common.collect.Lists;
import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.Expression;

@Slf4j
@SpringBootTest
class ConditionEvaluatorRegistryTest {

  @MockBean
  private OrgService orgService;
  @MockBean
  private RoleService roleService;

  @Test
  public void testEmployeeBelongWithSpringWithUsers() {
    // 编写表达式
    String expression = "employeeBelong(a, b)";
    // 表达式编译
    Expression compiledExp = AviatorEvaluator.compile(expression, true);
    Map<String, Object> env = new HashMap<>();

    env.put("a", new User().setUserId("001").setUserName("User001"));
    UserConditionDefinition def = new UserConditionDefinition();
    def.setUsers(Lists.newArrayList(new User().setUserId("002").setUserName("User002")));
    env.put("b", def);

    Object result = compiledExp.execute(env);
    Assertions.assertThat(result).isEqualTo(false);
  }

  @Test
  public void testEmployeeBelongWithSpring() {
    Mockito.when(orgService.employeeInDepartmentIds(Mockito.any(), Mockito.anyCollection()))
        .thenReturn(true);

    // 编写表达式
    String expression = "employeeBelong(a, b)";
    // 表达式编译
    Expression compiledExp = AviatorEvaluator.compile(expression, true);
    Map<String, Object> env = new HashMap<>();

    env.put("a", new User().setUserId("001").setUserName("User001"));
    UserConditionDefinition def = new UserConditionDefinition();
    def.setUsers(Lists.newArrayList(new User().setUserId("002").setUserName("User002")));
    def.setDepartments(Lists.newArrayList(new Department().setDeptId("001").setDeptName("Dept001")));
    env.put("b", def);

    Object result = compiledExp.execute(env);
    Assertions.assertThat(result).isEqualTo(true);
  }

  @Test
  public void testEmployeeBelongWithSpringWithRoles() {
    Mockito.when(orgService.employeeInDepartmentIds(Mockito.any(), Mockito.anyCollection()))
        .thenReturn(false);
    Mockito.when(roleService.employeeInRoles(Mockito.any(), Mockito.anyCollection()))
        .thenReturn(true);

    // 编写表达式
    String expression = "employeeBelong(a, b)";
    // 表达式编译
    Expression compiledExp = AviatorEvaluator.compile(expression, true);
    Map<String, Object> env = new HashMap<>();

    env.put("a", new User().setUserId("001").setUserName("User001"));
    UserConditionDefinition def = new UserConditionDefinition();
    def.setUsers(Lists.newArrayList(new User().setUserId("002").setUserName("User002")));
    def.setDepartments(Lists.newArrayList(new Department().setDeptId("001").setDeptName("Dept001")));
    def.setRoles(Lists.newArrayList(new Role().setRoleId("r001").setRoleName("Role001")));
    env.put("b", def);

    Object result = compiledExp.execute(env);
    Assertions.assertThat(result).isEqualTo(true);
  }

  private static UserConditionDefinition getUserConditionDefinition() {
    UserConditionDefinition def = new UserConditionDefinition();
    def.setUsers(Lists.newArrayList(new User().setUserId("002").setUserName("User002")));
    def.setDepartments(Lists.newArrayList(new Department().setDeptId("001").setDeptName("Dept001")));
    def.setRoles(Lists.newArrayList(new Role().setRoleId("r001").setRoleName("Role001")));
    return def;
  }

}