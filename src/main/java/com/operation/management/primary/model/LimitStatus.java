package com.operation.management.primary.model;

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
@Table(name = "limit_count_status")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class LimitStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Long uid;
    private String grp_cd;
    private String grp_nm;
    private String start_date;
    private String limit_price;
    private int used;
    private int percent;
    private int sms_cnt;
    private int lms_cnt;
    private int mms_cnt;
    private Date create_dttm;

    
    @Builder
      public LimitStatus(Long uid, String grp_cd, String grp_nm, String start_date,
                        String limit_price, int used, int percent, int sms_cnt,
                        int lms_cnt, int mms_cnt, Date create_dttm){
            this.uid = uid;
            this.grp_cd = grp_cd;
            this.grp_nm = grp_nm;
            this.start_date = start_date;
            this.limit_price = limit_price;
            this.used = used;
            this.percent = percent;
            this.sms_cnt = sms_cnt;
            this.lms_cnt = lms_cnt;
            this.mms_cnt = mms_cnt;
            this.create_dttm = create_dttm;

      }
    
}
