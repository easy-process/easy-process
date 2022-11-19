package com.easyprocess.core.content.process.conditions;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class ConditionDefinitionTests {

  @Test
  void testFindFunctionName() {
    String functionName = ConditionDefinition.getFunctionName("abc(123, __STARTER)");
    Assertions.assertThat(functionName).isEqualTo("abc");
  }
}
