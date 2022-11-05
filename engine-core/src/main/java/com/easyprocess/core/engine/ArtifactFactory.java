package com.easyprocess.core.engine;

public interface ArtifactFactory {

  <T> T getService(Class<T> clazz);

}
