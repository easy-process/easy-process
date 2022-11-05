package com.easyprocess.core.engine;

import lombok.Getter;
import lombok.Setter;

import com.easyprocess.core.content.form.instance.FormInstance;
import com.easyprocess.core.org.User;

@Getter
@Setter
public class EngineContext {

  private ArtifactFactory artifactFactory;

  //--------------------------------------runtime--------------------
  private User starter;

  private String starterDeptId;

  private String starterDeptName;

  private FormInstance formInstance;

  //--------------------------------------runtime--------------------
}
