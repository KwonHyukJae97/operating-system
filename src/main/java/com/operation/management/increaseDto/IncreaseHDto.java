package com.operation.management.increaseDto;

import java.util.Date;

import com.operation.management.increaseDomain.IncreaseH;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class IncreaseHDto {
    private Long uid;
    private String grp_cd;
    private String status;
    private String start_date;
    private String limit_price;
    private float sms_price;
    private float lms_price;
    private float mms_price;
    private String rmk;
    private Date create_dttm;

    @Builder
    public IncreaseHDto(IncreaseH increaseH){
        this.uid = increaseH.getUid();
        this.grp_cd = increaseH.getGrp_cd();
        this.status = increaseH.getStatus();
        this.start_date = increaseH.getStart_date();
        this.limit_price = increaseH.getLimit_price();
        this.sms_price = increaseH.getSms_price();
        this.lms_price = increaseH.getLms_price();
        this.mms_price = increaseH.getMms_price();
        this.rmk = increaseH.getRmk();
        this.create_dttm = increaseH.getCreate_dttm();
    }

    public IncreaseH toEntity(){
        return IncreaseH.builder().uid(uid)
                                  .grp_cd(grp_cd)
                                  .status(status)
                                  .start_date(start_date)
                                  .limit_price(limit_price)
                                  .sms_price(sms_price)
                                  .lms_price(lms_price)
                                  .mms_price(mms_price)
                                  .rmk(rmk)
                                  .create_dttm(create_dttm)
                                  .build();
    }
    
}
