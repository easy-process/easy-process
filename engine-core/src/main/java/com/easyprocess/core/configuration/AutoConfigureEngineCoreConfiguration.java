package com.easyprocess.core.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.easyprocess.core.engine.ArtifactFactory;
import com.easyprocess.core.engine.SpringArtifactFactory;

@Configuration
@ComponentScan(basePackages = "com.easyprocess.core")
public class AutoConfigureEngineCoreConfiguration {

  @Bean
  public ArtifactFactory artifactFactory() {
    return new SpringArtifactFactory();
  }

}
