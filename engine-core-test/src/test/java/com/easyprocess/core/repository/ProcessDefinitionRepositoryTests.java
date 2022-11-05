package com.easyprocess.core.repository;

import java.time.LocalDateTime;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.easyprocess.core.configuration.EnableEngineCore;
import com.easyprocess.core.entity.ProcessDefinitionEntity;
import com.easyprocess.core.enums.ProcessStatus;

@SpringBootTest
@EnableEngineCore
public class ProcessDefinitionRepositoryTests {

  @Autowired
  private ProcessDefinitionRepository processDefinitionRepository;

  @Test
  public void testFindById() {
    ProcessDefinitionEntity entity = new ProcessDefinitionEntity();
    processDefinitionRepository.save(entity.setKey("1111")
        .setFormContentId(1L)
        .setProcessContentId(1L)
        .setCreateTime(LocalDateTime.now())
        .setCreateUserId("User_001")
        .setVersion(1)
        .setStatus(ProcessStatus.INIT)
        .setName("TestProcessDefinition"));

    ProcessDefinitionEntity result = processDefinitionRepository.findById(1L).orElseThrow();
    Assertions.assertThat(result).isNotNull();
    Assertions.assertThat(result.getKey()).isEqualTo("1111");
  }

}
