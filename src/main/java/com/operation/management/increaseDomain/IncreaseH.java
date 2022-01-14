package com.operation.management.increaseDomain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "limit_count_history")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class IncreaseH {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(columnDefinition = "serial")
  private Long uid;
  @Column(updatable = false)
  private String grp_cd;
  private String status;
  @Column(updatable = false)
  private String start_date;
  private String limit_price;
  private float sms_price;
  private float lms_price;
  private float mms_price;
  @Column(updatable = false)
  private String rmk;
  @Column(updatable = false)
  private Date create_dttm;


  @Builder
    public IncreaseH(Long uid, String grp_cd, String status, String start_date, String limit_price,
    float sms_price, float lms_price, float mms_price, String rmk, Date create_dttm){
        this.uid = uid;
        this.grp_cd = grp_cd;
        this.status = status;
        this.start_date = start_date;
        this.limit_price = limit_price;
        this.sms_price = sms_price;
        this.lms_price = lms_price;
        this.mms_price = mms_price;
        this.rmk = rmk;
        this.create_dttm = create_dttm;
    }

}