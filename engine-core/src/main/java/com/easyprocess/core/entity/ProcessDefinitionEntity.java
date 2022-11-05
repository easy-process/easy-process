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

import com.easyprocess.core.enums.ProcessStatus;

@Setter
@Getter
@ToString
@Accessors(chain = true)
@Entity
@Table(
    indexes = {
        @Index(name = "f_form_content_id_idx", columnList = "formContentId"),
        @Index(name = "f_process_content_id_idx", columnList = "processContentId"),
        @Index(name = "f_group_id_idx", columnList = "groupId"),
        @Index(name = "u_key_version_idx", columnList = "key,version", unique = true),
    }
)
public class ProcessDefinitionEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  /**
   * 所属分组
   *
   * @see GroupEntity#getId()
   */
  private Long groupId;

  @Column(columnDefinition = "char(64) not null")
  private String key;

  @Column(columnDefinition = "varchar(30) not null")
  private String name;

  /**
   * 表单内容id
   *
   * @see ContentEntity#getId()
   */
  private Long formContentId;

  /**
   * 流程内容id
   *
   * @see ContentEntity#getId()
   */
  private Long processContentId;

  @Column(columnDefinition = "char(15) not null")
  private ProcessStatus status;

  @Column(columnDefinition = "int not null default 0")
  private Integer version;

  @Column(columnDefinition = "datetime not null")
  private LocalDateTime createTime;

  @Column(columnDefinition = "char(64) not null")
  private String createUserId;

  @Column(columnDefinition = "datetime")
  private LocalDateTime updateTime;

  @Column(columnDefinition = "char(64)")
  private String updateUserId;

}
