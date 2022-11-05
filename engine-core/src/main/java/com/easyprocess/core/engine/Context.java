package com.easyprocess.core.engine;

import com.easyprocess.core.org.OrgService;
import com.easyprocess.core.org.RoleService;

public class Context {

  private static final ThreadLocal<EngineContext> CONTEXT_HOLDER = ThreadLocal.withInitial(EngineContext::new);

  public static OrgService getOrgService() {
    return CONTEXT_HOLDER.get().getArtifactFactory().getService(OrgService.class);
  }

  public static RoleService getRoleService() {
    return CONTEXT_HOLDER.get().getArtifactFactory().getService(RoleService.class);
  }

  public static EngineContext getContext() {
    return CONTEXT_HOLDER.get();
  }

}
