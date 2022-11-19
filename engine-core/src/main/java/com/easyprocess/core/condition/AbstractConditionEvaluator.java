package com.easyprocess.core.condition;

import org.springframework.beans.factory.InitializingBean;

import com.googlecode.aviator.runtime.function.AbstractFunction;

public abstract class AbstractConditionEvaluator extends AbstractFunction implements InitializingBean, ConditionEvaluator {

  @Override
  public void afterPropertiesSet() {
    ConditionEvaluatorRegistry.register(this);
  }
}
