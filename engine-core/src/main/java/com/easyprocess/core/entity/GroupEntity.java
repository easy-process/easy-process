package com.easyprocess.core.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Setter
@Getter
@ToString
@Accessors(chain = true)
@Entity
public class GroupEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(columnDefinition = "varchar(30) not null", unique = true)
  private String name;

  @Column(columnDefinition = "int not null default 0")
  private Integer sort;

  @Column(columnDefinition = "datetime not null")
  private LocalDateTime createTime;

  @Column(columnDefinition = "datetime")
  private LocalDateTime updateTime;

}
