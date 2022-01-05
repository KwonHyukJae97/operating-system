package com.operation.management.vo;

import java.time.LocalDate;

import com.operation.management.domain.IncreaseH;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class IncreaseHVO {
    private Long uid;
    private String grp_cd;
    private String status;
    private String start_date;
    private String limit_price;
    private float sms_price;
    private float lms_price;
    private float mms_price;
    private String rmk;
    private LocalDate create_dttm;
    
    @Builder
    public IncreaseHVO(Long uid, String grp_cd, String status, String start_date, String limit_price,
    float sms_price, float lms_price, float mms_price, String rmk, LocalDate create_dttm){
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
