package com.easyprocess.core.repository;

import java.time.LocalDateTime;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.easyprocess.core.annotations.EnableEngineCore;
import com.easyprocess.core.entity.ProcessDefinitionEntity;

@SpringBootTest
@EnableEngineCore
public class ProcessDefinitionRepositoryTests {

  @Autowired
  private ProcessDefinitionRepository processDefinitionRepository;

  @Test
  public void testFindById() {
    ProcessDefinitionEntity entity = new ProcessDefinitionEntity();
    processDefinitionRepository.save(entity.setCode("1111")
        .setFormCode("Form_001")
        .setProcessCode("Process_001")
        .setCreateTime(LocalDateTime.now())
        .setName("TestProcessDefinition"));
    Optional<ProcessDefinitionEntity> optional = processDefinitionRepository.findById(1L);
    ProcessDefinitionEntity result = optional.get();
    Assertions.assertThat(result).isNotNull();
    Assertions.assertThat(result.getCode()).isEqualTo("1111");
  }

}
