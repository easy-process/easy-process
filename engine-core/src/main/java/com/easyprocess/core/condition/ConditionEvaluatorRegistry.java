package com.easyprocess.core.condition;

import com.googlecode.aviator.AviatorEvaluator;

public class ConditionEvaluatorRegistry {

  public static void register(AbstractConditionEvaluator evaluator) {
    AviatorEvaluator.addFunction(evaluator);
  }

}
