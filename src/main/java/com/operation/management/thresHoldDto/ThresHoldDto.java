package com.operation.management.thresHoldDto;

import javax.persistence.Column;

import com.operation.management.thresHoldDomain.ThresHold;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ThresHoldDto {
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
    public ThresHoldDto(ThresHold thresHold){
        this.grp_cd = thresHold.getGrp_cd();
        this.grp_nm = thresHold.getGrp_nm();
        this.start_date = thresHold.getStart_date();
        this.used_yn = thresHold.getUsed_yn();
        this.limit_price = thresHold.getLimit_price();
        this.sms_price = thresHold.getSms_price();
        this.lms_price = thresHold.getLms_price();
        this.mms_price = thresHold.getMms_price();
        this.alarm_group = thresHold.getAlarm_group();
        this.reset_yn = thresHold.getReset_yn();
        this.reset_day = thresHold.getReset_day();
        this.reset_price = thresHold.getReset_price();
        this.reset_dttm = thresHold.getReset_dttm();
    }

    public ThresHold toEntity(){
        return ThresHold.builder().grp_cd(grp_cd).grp_nm(grp_nm)
                        .start_date(start_date).used_yn(used_yn)
                        .limit_price(limit_price).sms_price(sms_price)
                        .lms_price(lms_price).mms_price(mms_price)
                        .alarm_group(alarm_group)
                        .reset_yn(reset_yn).reset_day(reset_day)
                        .reset_price(reset_price).reset_dttm(reset_dttm)
                        .build();    
    }
}
