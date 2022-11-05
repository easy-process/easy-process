package com.easyprocess.core.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Setter
@Getter
@ToString
@Accessors(chain = true)
@Entity
@Table(
    indexes = {
        @Index(name = "u_code_idx", columnList = "code", unique = true),
        @Index(name = "f_form_code_idx", columnList = "formCode"),
        @Index(name = "f_process_code_idx", columnList = "processCode")
    }
)
public class ProcessDefinitionEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(columnDefinition = "char(64) not null")
  private String code;

  @Column(columnDefinition = "varchar(30) not null")
  private String name;

  @Column(columnDefinition = "char(64) not null")
  private String formCode;

  @Column(columnDefinition = "char(64) not null")
  private String processCode;

  @Column(columnDefinition = "datetime not null")
  private LocalDateTime createTime;

  @Column(columnDefinition = "datetime")
  private LocalDateTime updateTime;

}
