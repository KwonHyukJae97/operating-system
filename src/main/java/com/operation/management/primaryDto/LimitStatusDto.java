package com.operation.management.primaryDto;

import java.util.Date;

import com.operation.management.primary.model.LimitStatus;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LimitStatusDto {
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
    public LimitStatusDto(LimitStatus limitStatus){
        this.uid = limitStatus.getUid();
        this.grp_cd = limitStatus.getGrp_cd();
        this.grp_nm = limitStatus.getGrp_nm();
        this.start_date = limitStatus.getStart_date();
        this.limit_price = limitStatus.getLimit_price();
        this.used = limitStatus.getUsed();
        this.percent = limitStatus.getPercent();
        this.sms_cnt = limitStatus.getSms_cnt();
        this.lms_cnt = limitStatus.getLms_cnt();
        this.mms_cnt = limitStatus.getMms_cnt();
        this.create_dttm = limitStatus.getCreate_dttm();
    }

    public LimitStatus toEntity(){
        return LimitStatus.builder().uid(uid)
                                    .grp_cd(grp_cd)
                                    .grp_nm(grp_nm)
                                    .start_date(start_date)
                                    .limit_price(limit_price)
                                    .used(used)
                                    .percent(percent)
                                    .sms_cnt(sms_cnt)
                                    .lms_cnt(lms_cnt)
                                    .mms_cnt(mms_cnt)
                                    .create_dttm(create_dttm)
                                    .build();
    }
}
