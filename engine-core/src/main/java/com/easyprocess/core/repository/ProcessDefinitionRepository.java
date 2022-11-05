package com.easyprocess.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.easyprocess.core.entity.ProcessDefinitionEntity;

@Repository
public interface ProcessDefinitionRepository extends JpaRepository<ProcessDefinitionEntity, Long> {

}
