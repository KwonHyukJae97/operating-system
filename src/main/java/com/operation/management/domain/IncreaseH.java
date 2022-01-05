package com.operation.management.IncreaseHistory;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "limit_count_history")
@Data
public class IncreaseH {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(columnDefinition = "serial")
  private Long uid;
  private String grp_cd;
  private String status;
  private String start_date;
  private String limit_price;
  private float sms_limit;
  private float lms_limit;
  private float mms_limit;
  private String rmk;
  private LocalDate create_dttm;

}