package com.easyprocess.core.content.process.conditions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import lombok.Data;

@Data
public class ConditionDefinition {

  public static final Pattern FUNCTION_NAME_EXTRACTOR = Pattern.compile("(.*)\\(.*\\)");

  /**
   * 表达式
   */
  private String expression;

  /**
   * 是否取反
   */
  private boolean reverse;

  /**
   * 实际参数定义 用于生成描述
   */
  private String actualDefinition;

  private Object operands;

  public static String getFunctionName(String expression) {
    Matcher matcher = FUNCTION_NAME_EXTRACTOR.matcher(expression);
    if (matcher.find()) {
      return matcher.group(1);
    }
    throw new RuntimeException(String.format("表达式解析有误 : %s", expression));
  }
}
