package com.operation.management.dto;

import java.time.LocalDate;
import java.util.Date;

import com.operation.management.domain.IncreaseH;

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
    // private String fDate;

     // @CreationTimestamp
  //   private Timestamp create_dttm;
  //insert시 자동으로 등록한 시간 업데이트
    
    // @Builder
    // public IncreaseHDto(Long uid, String grp_cd, String status, String start_date, String limit_price,
    // float sms_price, float lms_price, float mms_price, String rmk, LocalDate create_dttm){
    //     this.uid = uid;
    //     this.grp_cd = grp_cd;
    //     this.status = status;
    //     this.start_date = start_date;
    //     this.limit_price = limit_price;
    //     this.sms_price = sms_price;
    //     this.lms_price = lms_price;
    //     this.mms_price = mms_price;
    //     this.rmk = rmk;
    //     this.create_dttm = create_dttm;
    // }

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
