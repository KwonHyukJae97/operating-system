package com.operation.management.primary.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "limit_count_threshold")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class ThresHold {

    @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    // @Column(name = "grp_cd")
    private String grp_cd;

    private String grp_nm;
    
    private String start_date;
    
    private String used_yn;
    
    private String limit_price;
    
    private float sms_price;
    
    private float lms_price;
    
    private float mms_price;
    
    private String alarm_group;
    
    private String reset_yn;
    
    private String reset_day;
    private String reset_price;
    private String reset_dttm;

    @Builder
        public ThresHold(String grp_cd, String grp_nm, String start_date,
         String used_yn, String limit_price, float sms_price, float lms_price, 
        float mms_price, String alarm_group, String reset_yn, String reset_day,
         String reset_price, String reset_dttm) {
             this.grp_cd = grp_cd;
             this.grp_nm = grp_nm;
             this.start_date = start_date;
             this.used_yn = used_yn;
             this.limit_price = limit_price;
             this.sms_price = sms_price;
             this.lms_price = lms_price;
             this.mms_price = mms_price;
             this.alarm_group = alarm_group;
             this.reset_yn = reset_yn;
             this.reset_day = reset_day;
             this.reset_price = reset_price;
             this.reset_dttm = reset_dttm;
        }

    
}