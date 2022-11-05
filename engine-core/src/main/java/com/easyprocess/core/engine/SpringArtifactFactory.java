package com.easyprocess.core.engine;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class SpringArtifactFactory implements ArtifactFactory, ApplicationContextAware {

  private ApplicationContext applicationContext;

  public <T> T getService(Class<T> clazz) {
    return applicationContext.getBean(clazz);
  }

  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    this.applicationContext = applicationContext;
  }

}
