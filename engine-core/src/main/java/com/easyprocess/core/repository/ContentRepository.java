package com.easyprocess.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.easyprocess.core.entity.ContentEntity;

@Repository
public interface ContentRepository extends JpaRepository<ContentEntity, Long> {
}
